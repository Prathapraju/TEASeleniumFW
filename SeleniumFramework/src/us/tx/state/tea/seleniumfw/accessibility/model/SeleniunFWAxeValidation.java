
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
    "help",
    "nodes",
    "impact",
    "description",
    "helpUrl",
    "id",
    "tags"
})
public class SeleniunFWAxeValidation {

    @JsonProperty("help")
    private String help;
    @JsonProperty("nodes")
    private List<SeleniunFWAxeNode> nodes = null;
    @JsonProperty("impact")
    private String impact;
    @JsonProperty("description")
    private String description;
    @JsonProperty("helpUrl")
    private String helpUrl;
    @JsonProperty("id")
    private String id;
    @JsonProperty("tags")
    private List<String> tags = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("help")
    public String getHelp() {
        return help;
    }

    @JsonProperty("help")
    public void setHelp(String help) {
        this.help = help;
    }

    @JsonProperty("nodes")
    public List<SeleniunFWAxeNode> getNodes() {
        return nodes;
    }

    @JsonProperty("nodes")
    public void setNodes(List<SeleniunFWAxeNode> nodes) {
        this.nodes = nodes;
    }

    @JsonProperty("impact")
    public String getImpact() {
        return impact;
    }

    @JsonProperty("impact")
    public void setImpact(String impact) {
        this.impact = impact;
    }

    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    @JsonProperty("helpUrl")
    public String getHelpUrl() {
        return helpUrl;
    }

    @JsonProperty("helpUrl")
    public void setHelpUrl(String helpUrl) {
        this.helpUrl = helpUrl;
    }

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    @JsonProperty("tags")
    public List<String> getTags() {
        return tags;
    }

    @JsonProperty("tags")
    public void setTags(List<String> tags) {
        this.tags = tags;
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
