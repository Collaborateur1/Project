package controller;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import model.custom.UserCustom;
import model.job.MultipartMap;
import model.job.UserJob;

@Controller
@Path( "/file" )
public class RestMediaController {
    private static final int DEFAULT_BUFFER_SIZE = 102400; // 10 ko
    private static final int TAILLE_TAMPON_CACHE = 1024000;
    private MultipartMap     multipartmap;
    /*à automatiser car sa doit etre paramétrable depuis l'extérieur*/
    private String              UserEnvironement="\\fichiers\\";
    private String              prefixDir                 = "C:";

    @Resource
    private ServletContext   context;
    
    @Autowired( required = true )
    UserJob               userjob;
    
    @javax.annotation.security.RolesAllowed( { "Connected" } )
    @GET
    @Path( "/pictures/{picture}" )
    public void getPictures( @Context SecurityContext sc, @PathParam( "picture" ) String picture,
            @Context HttpServletResponse response) throws URISyntaxException {
       
        try {

            String typeDownload = null;//httpRequest.getParameter( "type" );

            if ( typeDownload == null ) {
                typeDownload = "inline";

            }

            /* Vérifie qu'un nom de fichier */
            if ( picture == null || "".equals( picture ) ) {
                /*
                 * Si non, alors on envoie une erreur 404, qui signifie que la
                 * ressource demandée n'existe pas
                 */

                response.sendError( HttpServletResponse.SC_NOT_FOUND );
                return;
            }

            try {
                picture=((UserCustom)sc.getUserPrincipal()).getDusEmail()+"/"+picture;
                picture = URLDecoder.decode( picture, "UTF-8" );
            } catch ( UnsupportedEncodingException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            PutFileInHeader( response, picture, typeDownload );

        } catch ( IOException e ) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @javax.annotation.security.RolesAllowed( { "Connected" } )
    @GET
    @Path( "/media2" )
    public Response getMedia( @Context HttpServletRequest httpRequest ,@Context SecurityContext sc) throws URISyntaxException {
       
        
        return Response.ok().build();

    }

    @javax.annotation.security.RolesAllowed( { "Connected" } )
    @GET
    @Path( "/media3" )
    public Response getFiles( @Context HttpServletRequest httpRequest ) throws URISyntaxException {

        return Response.ok().build();

    }

   /* @javax.annotation.security.RolesAllowed( { "Connected" } )
    @POST
    @Path( "/pictures" )
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response setPictures( @Context HttpServletRequest httpRequest,@Context SecurityContext sc,@FormDataParam("file") InputStream uploadedInputStream,
            @FormDataParam("file") FormDataContentDisposition fileDetail) throws URISyntaxException {
       
        
        
            UserCustom user=((UserCustom)sc.getUserPrincipal());
            String uploadedFileLocation = prefixDir+UserEnvironement+"\\"+user.getDusEmail() +"\\"+fileDetail.getFileName();

            // save it
            writeToFile(uploadedInputStream, uploadedFileLocation);

            String output = "File uploaded to : " + uploadedFileLocation;
            
            return Response.status(200).entity(output).build();
         
     
    }
    */

    @javax.annotation.security.RolesAllowed( { "Connected" } )
    @GET
    @Path( "/media4" )
    public Response setMedia( @Context HttpServletRequest httpRequest ) throws URISyntaxException {

        return Response.ok().build();

    }

    @javax.annotation.security.RolesAllowed( { "Connected" } )
    @GET
    @Path( "/media5" )
    public Response setFiles( @Context HttpServletRequest httpRequest ) throws URISyntaxException {

        return Response.ok().build();

    }

    /**
     * name - PutFileInHeader description: Fr:toutes les étapes pour charger une
     * image dans le header (image jamais chargé) Eng:
     * 
     * @param HttpServletResponse
     *            :
     * @param String
     *            : file patch to charge
     * @author jean-vincent
     * @return
     * @date 01/01/2016
     * @note
     */

    public void PutFileInHeader( HttpServletResponse response, String fichierRequis, String typeDownload )
            throws IOException {
        // a faire évoluer /fichiers pas tres propre, devra detecter quel type
        File fichier = new File(  prefixDir+ UserEnvironement+ fichierRequis );
        if ( !fichier.exists() ) {

            /*
             * Si non, alors on envoie une erreur 404, qui signifie que la
             * ressource demandée n'existe pas
             */

            response.sendError( HttpServletResponse.SC_NOT_FOUND );
            return;

        }

        /* Récupère le type du fichier */
        String type = typeInitialize( fichier );

        /* Initialise la réponse HTTP */
        httpInitialize( response, type, fichier, typeDownload );

        PutFileInResponse( response, fichier );
    }

    /**
     * name - typeInitialize description: Fr:obtien le type du fichier Eng:
     * 
     * @param File
     *            : file to work on
     * @author jean-vincent
     * @date 01/01/2016
     * @note
     */
    public String typeInitialize( File fichier ) {
        String type = context.getMimeType( fichier.getName() );
        /*
         * Si le type de fichier est inconnu, alors on initialise un type par
         * défaut
         */

        if ( type == null ) {

            type = "application/octet-stream";

        }
        return type;
    }

    /**
     * name - httpInitialize description: Fr:initialise la réponse http Eng:
     * 
     * @param HttpServletResponse
     *            :
     * @param File
     *            : file to work on
     * @param String
     *            : file type
     * @author jean-vincent
     * @date 01/01/2016
     * @note
     */
    public void httpInitialize( HttpServletResponse response, String type, File fichier, String typeDownload ) {
        /* Initialise la réponse HTTP */
        response.reset();
        response.setBufferSize( DEFAULT_BUFFER_SIZE );
        response.setContentType( type );
        response.setHeader( "Content-Length", String.valueOf( fichier.length() ) );
        response.setHeader( "Content-Disposition", typeDownload + "; filename=\"" + fichier.getName() + "\"" );
    }

    /**
     * name - PutFileInResponse description: Fr:copie le fichier image dans la
     * reponse avec un tampon pr ne pas saturer la mémoire Eng:
     * 
     * @param HttpServletResponse
     *            :
     * @param File
     *            : file to charge
     * @author jean-vincent
     * @date 01/01/2016
     * @note
     */

    public void PutFileInResponse( HttpServletResponse resp, File fichier ) throws IOException {
        /* Prépare les flux */
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            /* Ouvre les flux */
            entree = new BufferedInputStream( new FileInputStream( fichier ), TAILLE_TAMPON_CACHE );
            sortie = new BufferedOutputStream( resp.getOutputStream(), TAILLE_TAMPON_CACHE );

            /* Lit le fichier et écrit son contenu dans la réponse HTTP */
            byte[] tampon = new byte[TAILLE_TAMPON_CACHE];
            int longueur;
            while ( ( longueur = entree.read( tampon ) ) > 0 ) {
                sortie.write( tampon, 0, longueur );
            }
        } finally {
            try {
                sortie.close();
            } catch ( IOException ignore ) {
            }
            try {
                entree.close();
            } catch ( IOException ignore ) {
            }
        }
    }

    /**
     * name - PutFileInResponse description: Fr:copie le fichier image dans la
     * reponse sans tampon Eng: !!ne marche pas!
     * 
     * @param HttpServletResponse
     *            :
     * @param File
     *            : file to charge
     * @author jean-vincent
     * @date 01/01/2016
     * @note
     */
    public void PutExistingFileInResponse( HttpServletResponse response, File fichier ) throws IOException {
        /* Prépare les flux */

        OutputStream out = null;

        String fileNamefichier = fichier.getName();
        String[] temp = fileNamefichier.split( "\\." );
        String extentionFile = temp[temp.length - 1];
        BufferedImage bi = null;
        try {
            /* Ouvre les flux */

            bi = ImageIO.read( fichier );
            out = response.getOutputStream();
            ImageIO.write( bi, extentionFile.toLowerCase(), out );

        } finally {
            try {
                out.close();
                response.flushBuffer();
            } catch ( IOException ignore ) {
            }

        }
    }
    
  

    // save uploaded file to new location
    private void writeToFile(InputStream uploadedInputStream,
        String uploadedFileLocation) {
        OutputStream out=null;
        try {
             out = new FileOutputStream(new File(
                    uploadedFileLocation));
            int read = 0;
            byte[] bytes = new byte[1024];

            out = new FileOutputStream(new File(uploadedFileLocation));
            while ((read = uploadedInputStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            
        } catch (IOException e) {

            e.printStackTrace();
        }finally{
            try {
                out.flush();
                out.close();
                out=null;
                System.gc();
                uploadedInputStream.close();
                
            } catch ( IOException e ) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
        }

    }
}
