
package us.tx.state.tea.seleniumfw.accessibility.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "data",
    "impact",
    "relatedNodes",
    "id",
    "message"
})
public class SeleniunFWAxeAny {

    @JsonProperty("data")
    private Object data;
    @JsonProperty("impact")
    private String impact;
    @JsonProperty("relatedNodes")
    private List<SeleniunFWAxeRelatedNode> relatedNodes = null;
    @JsonProperty("id")
    private String id;
    @JsonProperty("message")
    private String message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("data")
    public Object getData() {
        return data;
    }

    @JsonProperty("data")
    public void setData(Object data) {
        this.data = data;
    }

    @JsonProperty("impact")
    public String getImpact() {
        return impact;
    }

    @JsonProperty("impact")
    public void setImpact(String impact) {
        this.impact = impact;
    }

    @JsonProperty("relatedNodes")
    public List<SeleniunFWAxeRelatedNode> getRelatedNodes() {
        return relatedNodes;
    }

    @JsonProperty("relatedNodes")
    public void setRelatedNodes(List<SeleniunFWAxeRelatedNode> relatedNodes) {
        this.relatedNodes = relatedNodes;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
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
