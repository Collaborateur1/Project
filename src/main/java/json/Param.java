
package json;

import java.util.HashMap;
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
    "Field",
    "Value",
    "Operation"
})
public class Param {

    @JsonProperty("Field")
    private String field;
    @JsonProperty("Value")
    private String value;
    @JsonProperty("Operation")
    private String operation;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Param() {
    }

    /**
     * 
     * @param field
     * @param operation
     * @param value
     */
    public Param(String field, String value, String operation) {
        this.field = field;
        this.value = value;
        this.operation = operation;
    }

    /**
     * 
     * @return
     *     The field
     */
    @JsonProperty("Field")
    public String getField() {
        return field;
    }

    /**
     * 
     * @param field
     *     The Field
     */
    @JsonProperty("Field")
    public void setField(String field) {
        this.field = field;
    }

    /**
     * 
     * @return
     *     The value
     */
    @JsonProperty("Value")
    public String getValue() {
        return value;
    }

    /**
     * 
     * @param value
     *     The Value
     */
    @JsonProperty("Value")
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 
     * @return
     *     The operation
     */
    @JsonProperty("Operation")
    public String getOperation() {
        return operation;
    }

    /**
     * 
     * @param operation
     *     The Operation
     */
    @JsonProperty("Operation")
    public void setOperation(String operation) {
        this.operation = operation;
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
