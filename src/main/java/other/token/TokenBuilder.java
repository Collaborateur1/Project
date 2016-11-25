package other.token;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Key;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.naming.OperationNotSupportedException;
import javax.xml.bind.DatatypeConverter;

import org.apache.log4j.Logger;

import com.auth0.jwt.Algorithm;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.ObjectMapper;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.auth0.jwt.internal.com.fasterxml.jackson.databind.node.ObjectNode;
import com.auth0.jwt.internal.org.apache.commons.codec.binary.Base64;

import filter.security.HttpHeaderNames;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import model.bean.DefaultUser.Role;
import model.custom.UserCustom;
import other.DefaultProperties;

public class TokenBuilder {
    private static Logger   logger       = Logger.getLogger( TokenBuilder.class );
    private final byte[] secret=DefaultProperties.getOption( "secretKey" ).getBytes();
    public static  String createAuthToken(String id, String issuer, String subject, String mdp, long ttlMillis) {

      //The JWT signature algorithm we will be using to sign the token
      SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

      long nowMillis = System.currentTimeMillis();
      Date now = new Date(nowMillis);

      //We will sign our JWT with our ApiKey secret
      byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(DefaultProperties.getOption( "secretKey" ));
      Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //Let's set the JWT Claims
      JwtBuilder builder = Jwts.builder().setId(id)
                                      .setIssuedAt(now).claim( "mdp", mdp )
                                      .setSubject(subject)
                                      .setIssuer(issuer)
                                      .signWith(signatureAlgorithm, signingKey);

       //if it has been specified, let's add the expiration
      if (ttlMillis >= 0) {
          long expMillis = nowMillis + ttlMillis;
          Date exp = new Date(expMillis);
          builder.setExpiration(exp);
      }

       //Builds the JWT and serializes it to a compact, URL-safe string
      return builder.compact();
      }
    
    public static  String createServiceKeyToken(String issuer, String subject, long ttlMillis) {

        //The JWT signature algorithm we will be using to sign the token
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //We will sign our JWT with our ApiKey secret
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(DefaultProperties.getOption( "secretKey" ));
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

          //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder()
                                        .setIssuedAt(now)
                                        .setSubject(subject)
                                        .setIssuer(issuer)
                                        .signWith(signatureAlgorithm, signingKey);

         //if it has been specified, let's add the expiration
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }

         //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
        }
    
    public static boolean tokenAuthIsValide( String token, UserCustom user ) {
        boolean valide = false;
        Claims claims = null;
        try {
            claims = Jwts.parser()
                    .setSigningKey( DatatypeConverter.parseBase64Binary( DefaultProperties.getOption( "secretKey" ) ) )
                    .parseClaimsJws( token ).getBody();
            
            String actorCacheOption=DefaultProperties.getOption( "actorCache" );
            valide=true;
            if("true".equals( actorCacheOption.toLowerCase())) {
                if(user==null)
                    throw new Exception("No valide user for this tocken");
            valide = claims.getIssuer().equals( user.getDusEmail() )
                    && claims.getSubject().equals( HttpHeaderNames.AUTH_TOKEN )
                    && claims.getId().trim().equals( user.getDusID().toString() )
                    && claims.get( "mdp" ).equals( user.getDusMdp() );

            }else{
                
                user.setDusEmail( claims.getIssuer() );
               user.setDusID( Long.parseLong(claims.getId().trim()));
               user.setDusToken( token );
               user.addRole( Role.Connected );
            }
        } catch ( Exception ex ) {
            logger.error( ex.getStackTrace()[0].getMethodName(),ex);
            valide=false;
        }

       
        return valide;

    }
    
    public static boolean tokenServiceKeyIsValide(String token,String ip)
    {
        
        Claims claims = Jwts.parser()         
                .setSigningKey(DatatypeConverter.parseBase64Binary(DefaultProperties.getOption( "secretKey" )))
                .parseClaimsJws(token).getBody();
        
        boolean valide;
        valide=claims.getIssuer().equals( ip )&&claims.getSubject().equals( HttpHeaderNames.SERVICE_KEY );
        return valide;
        
        
    }
    
    
    
    
    /**
     * Generate a JSON Web Token.
     *  using the default algorithm HMAC SHA-256 ("HS256")
     * and no claims automatically set.
     *
     * @param claims A map of the JWT claims that form the payload. Registered claims
     *               must be of appropriate Java datatype as following:
     *               <ul>
     *                  <li>iss, sub: String
     *                  <li>exp, nbf, iat, jti: numeric, eg. Long
     *                  <li>aud: String, or Collection&lt;String&gt;
     *               </ul>
     *               All claims with a null value are left out the JWT.
     *               Any claims set automatically as specified in
     *               the "options" parameter override claims in this map.
     *
     *
     * @param options Allow choosing the signing algorithm, and automatic setting of some registered claims.
     */
    public String sign(Map<String, Object> claims, Options options) {
        Algorithm algorithm = Algorithm.HS256;
        if (options != null && options.algorithm != null)
            algorithm = options.algorithm;

        List<String> segments = new ArrayList<String>();
        try {
            segments.add(encodedHeader(algorithm));
            segments.add(encodedPayload(claims, options));
            segments.add(encodedSignature(join(segments, "."), algorithm));
        } catch (Exception e) {
            throw (e instanceof RuntimeException) ? (RuntimeException) e : new RuntimeException(e);
        }

        return join(segments, ".");
    }
    
    /**
     * Sign the header and payload
     */
    private String encodedSignature(String signingInput, Algorithm algorithm) throws Exception {
        byte[] signature = sign(algorithm, signingInput, secret);
        return base64UrlEncode(signature);
    }
    /**
     * Switch the signing algorithm based on input, RSA not supported
     */
    private static byte[] sign(Algorithm algorithm, String msg, byte[] secret) throws Exception {
        switch (algorithm) {
        case HS256:
        case HS384:
        case HS512:
            return signHmac(algorithm, msg, secret);
        case RS256:
        case RS384:
        case RS512:
        default:
            throw new OperationNotSupportedException("Unsupported signing method");
        }
    }

    /**
     * Sign an input string using HMAC and return the encrypted bytes
     */
    private static byte[] signHmac(Algorithm algorithm, String msg, byte[] secret) throws Exception {
        Mac mac = Mac.getInstance(algorithm.getValue());
        mac.init(new SecretKeySpec(secret, algorithm.getValue()));
        return mac.doFinal(msg.getBytes());
    }
    
    /**
     * Generate the header part of a JSON web token.
     */
    private String encodedHeader(Algorithm algorithm) throws UnsupportedEncodingException {
        if (algorithm == null) { // default the algorithm if not specified
            algorithm = Algorithm.HS256;
        }

        // create the header
        ObjectNode header = JsonNodeFactory.instance.objectNode();
        header.put("typ", "JWT");
        header.put("alg", algorithm.name());

        return base64UrlEncode(header.toString().getBytes("UTF-8"));
    }
    
    /**
     * Safe URL encode a byte array to a String
     */
    private String base64UrlEncode(byte[] str) {
        return new String(Base64.encodeBase64URLSafe(str));
    }
    
    private String join(List<String> input, String on) {
        int size = input.size();
        int count = 1;
        StringBuilder joined = new StringBuilder();
        for (String string : input) {
            joined.append(string);
            if (count < size) {
                joined.append(on);
            }
            count++;
        }

        return joined.toString();
    }

    /**
     * An option object for JWT signing operation. Allow choosing the algorithm, and/or specifying
     * claims to be automatically set.
     */
    public static class Options {
        private Algorithm algorithm;
        private Integer expirySeconds;
        private Integer notValidBeforeLeeway;
        private boolean issuedAt;
        private boolean jwtId;

        public Algorithm getAlgorithm() {
            return algorithm;
        }
        /**
         * Algorithm to sign JWT with. Default is <code>HS256</code>.
         */
        public Options setAlgorithm(Algorithm algorithm) {
            this.algorithm = algorithm;
            return this;
        }


        public Integer getExpirySeconds() {
            return expirySeconds;
        }
        /**
         * Set JWT claim "exp" to current timestamp plus this value.
         * Overrides content of <code>claims</code> in <code>sign()</code>.
         */
        public Options setExpirySeconds(Integer expirySeconds) {
            this.expirySeconds = expirySeconds;
            return this;
        }

        public Integer getNotValidBeforeLeeway() {
            return notValidBeforeLeeway;
        }
        /**
         * Set JWT claim "nbf" to current timestamp minus this value.
         * Overrides content of <code>claims</code> in <code>sign()</code>.
         */
        public Options setNotValidBeforeLeeway(Integer notValidBeforeLeeway) {
            this.notValidBeforeLeeway = notValidBeforeLeeway;
            return this;
        }

        public boolean isIssuedAt() {
            return issuedAt;
        }
        /**
         * Set JWT claim "iat" to current timestamp. Defaults to false.
         * Overrides content of <code>claims</code> in <code>sign()</code>.
         */
        public Options setIssuedAt(boolean issuedAt) {
            this.issuedAt = issuedAt;
            return this;
        }

        public boolean isJwtId() {
            return jwtId;
        }
        /**
         * Set JWT claim "jti" to a pseudo random unique value (type 4 UUID). Defaults to false.
         * Overrides content of <code>claims</code> in <code>sign()</code>.
         */
        public Options setJwtId(boolean jwtId) {
            this.jwtId = jwtId;
            return this;
        }
    }
    
    /**
     * Generate the JSON web token payload string from the claims.
     * @param options
     */
    private String encodedPayload(Map<String, Object> _claims, Options options) throws Exception {
        Map<String, Object> claims = new HashMap<String, Object>(_claims);
        enforceStringOrURI(claims, "iss");
        enforceStringOrURI(claims, "sub");
        enforceStringOrURICollection(claims, "aud");
        enforceIntDate(claims, "exp");
        enforceIntDate(claims, "nbf");
        enforceIntDate(claims, "iat");
        enforceString(claims, "jti");

        if (options != null)
            processPayloadOptions(claims, options);

        String payload = new ObjectMapper().writeValueAsString(claims);
        return base64UrlEncode(payload.getBytes("UTF-8"));
    }
    private void enforceStringOrURI(Map<String, Object> claims, String claimName) {
        Object value = handleNullValue(claims, claimName);
        if (value == null)
            return;
        String error = checkStringOrURI(value);
        if (error != null)
            throw new RuntimeException(String.format("Claim '%s' is invalid: %s", claimName, error));
    }
    private Object handleNullValue(Map<String, Object> claims, String claimName) {
        if (! claims.containsKey(claimName))
            return null;
        Object value = claims.get(claimName);
        if (value == null) {
            claims.remove(claimName);
            return null;
        }
        return value;
    }
    private String checkStringOrURI(Object value) {
        if (!(value instanceof String))
            return "not a string";
        String stringOrUri = (String) value;
        if (!stringOrUri.contains(":"))
            return null;
        try {
            new URI(stringOrUri);
        } catch (URISyntaxException e) {
            return "not a valid URI";
        }
        return null;
    }
    
    private void enforceStringOrURICollection(Map<String, Object> claims, String claimName) {
        Object values = handleNullValue(claims, claimName);
        if (values == null)
            return;
        if (values instanceof Collection) {
            @SuppressWarnings({ "unchecked" })
            Iterator<Object> iterator = ((Collection<Object>) values).iterator();
            while (iterator.hasNext()) {
                Object value = iterator.next();
                String error = checkStringOrURI(value);
                if (error != null)
                    throw new RuntimeException(String.format("Claim 'aud' element is invalid: %s", error));
            }
        } else {
            enforceStringOrURI(claims, "aud");
        }
    }
    private void enforceIntDate(Map<String, Object> claims, String claimName) {
        Object value = handleNullValue(claims, claimName);
        if (value == null)
            return;
        if (!(value instanceof Number)) {
            throw new RuntimeException(String.format("Claim '%s' is invalid: must be an instance of Number", claimName));
        }
        long longValue = ((Number) value).longValue();
        if (longValue < 0)
            throw new RuntimeException(String.format("Claim '%s' is invalid: must be non-negative", claimName));
        claims.put(claimName, longValue);
    }
    
    private void enforceString(Map<String, Object> claims, String claimName) {
        Object value = handleNullValue(claims, claimName);
        if (value == null)
            return;
        if (!(value instanceof String))
            throw new RuntimeException(String.format("Claim '%s' is invalid: not a string", claimName));
    }
    private void processPayloadOptions(Map<String, Object> claims, Options options) {
        long now = System.currentTimeMillis() / 1000l;
        if (options.expirySeconds != null)
            claims.put("exp", now + options.expirySeconds);
        if (options.notValidBeforeLeeway != null)
            claims.put("nbf", now - options.notValidBeforeLeeway);
        if (options.isIssuedAt())
            claims.put("iat", now);
        if (options.isJwtId())
            claims.put("jti", UUID.randomUUID().toString());
    }

}

