
package json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import model.bean.Availability;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "availabilitys"
})
public class Availabilitys {

    @JsonProperty("availabilitys")
    private List<Availability> availabilitys = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("availabilitys")
    public List<Availability> getAvailabilitys() {
        return availabilitys;
    }

    @JsonProperty("availabilitys")
    public void setAvailabilitys(List<Availability> availabilitys) {
       if(this.availabilitys==null||this.availabilitys.isEmpty())
        this.availabilitys = availabilitys;
       else{
          this.availabilitys.addAll( availabilitys ) ;
       }
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
    
    public void addAvailabilitys(Availability availability) {
       if(this.availabilitys==null)
           this.availabilitys=new ArrayList<>();
       this.availabilitys.add(availability);
    }
    
    public Availability getAvailabilitys(int index) {
        if(this.availabilitys==null||this.availabilitys.size()<=index)
           return null;
        return this.availabilitys.get(index);
     }
    
    

}
