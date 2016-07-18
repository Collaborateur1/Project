
package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Generated;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "ope",
    "value"
})
public class Order {

    @JsonProperty("ope")
    private String ope;
    @JsonProperty("value")
    private List<String> value = new ArrayList<String>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Order() {
    }

    /**
     * 
     * @param value
     * @param ope
     */
    public Order(String ope, List<String> value) {
        this.ope = ope;
        this.value = value;
    }

    /**
     * 
     * @return
     *     The ope
     */
    @JsonProperty("ope")
    public String getOpe() {
        return ope;
    }

    /**
     * 
     * @param ope
     *     The ope
     */
    @JsonProperty("ope")
    public void setOpe(String ope) {
        this.ope = ope;
    }

    /**
     * 
     * @return
     *     The value
     */
    @JsonProperty("value")
    public List<String> getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The value
     */
    @JsonProperty("value")
    public void setValue(List<String> value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
