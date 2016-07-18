
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
    "param",
    "order",
    "projection",
    "alias"
})
public class Jsonmap {

    @JsonProperty("param")
    private List<Param> param = new ArrayList<Param>();
    @JsonProperty("order")
    private List<Order> order = new ArrayList<Order>();
    @JsonProperty("projection")
    private List<Projection> projection = new ArrayList<Projection>();
    @JsonProperty("alias")
    private List<Alia> alias = new ArrayList<Alia>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * No args constructor for use in serialization
     * 
     */
    public Jsonmap() {
    }

    /**
     * 
     * @param order
     * @param alias
     * @param param
     * @param projection
     */
    public Jsonmap(List<Param> param, List<Order> order, List<Projection> projection, List<Alia> alias) {
        this.param = param;
        this.order = order;
        this.projection = projection;
        this.alias = alias;
    }

    /**
     * 
     * @return
     *     The param
     */
    @JsonProperty("param")
    public List<Param> getParam() {
        return param;
    }

    /**
     * 
     * @param param
     *     The param
     */
    @JsonProperty("param")
    public void setParam(List<Param> param) {
        this.param = param;
    }

    /**
     * 
     * @return
     *     The order
     */
    @JsonProperty("order")
    public List<Order> getOrder() {
        return order;
    }

    /**
     * 
     * @param order
     *     The order
     */
    @JsonProperty("order")
    public void setOrder(List<Order> order) {
        this.order = order;
    }

    /**
     * 
     * @return
     *     The projection
     */
    @JsonProperty("projection")
    public List<Projection> getProjection() {
        return projection;
    }

    /**
     * 
     * @param projection
     *     The projection
     */
    @JsonProperty("projection")
    public void setProjection(List<Projection> projection) {
        this.projection = projection;
    }

    /**
     * 
     * @return
     *     The alias
     */
    @JsonProperty("alias")
    public List<Alia> getAlias() {
        return alias;
    }

    /**
     * 
     * @param alias
     *     The alias
     */
    @JsonProperty("alias")
    public void setAlias(List<Alia> alias) {
        this.alias = alias;
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
