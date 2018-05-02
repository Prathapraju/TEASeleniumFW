
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
    "all",
    "xpath",
    "impact",
    "html",
    "none",
    "any",
    "target"
})
public class SeleniunFWAxeNode {

    @JsonProperty("all")
    private List<Object> all = null;
    @JsonProperty("xpath")
    private List<String> xpath = null;
    @JsonProperty("impact")
    private String impact;
    @JsonProperty("html")
    private String html;
    @JsonProperty("none")
    private List<Object> none = null;
    @JsonProperty("any")
    private List<SeleniunFWAxeAny> any = null;
    @JsonProperty("target")
    private List<String> target = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("all")
    public List<Object> getAll() {
        return all;
    }

    @JsonProperty("all")
    public void setAll(List<Object> all) {
        this.all = all;
    }

    @JsonProperty("xpath")
    public List<String> getXpath() {
        return xpath;
    }

    @JsonProperty("xpath")
    public void setXpath(List<String> xpath) {
        this.xpath = xpath;
    }

    @JsonProperty("impact")
    public String getImpact() {
        return impact;
    }

    @JsonProperty("impact")
    public void setImpact(String impact) {
        this.impact = impact;
    }

    @JsonProperty("html")
    public String getHtml() {
        return html;
    }

    @JsonProperty("html")
    public void setHtml(String html) {
        this.html = html;
    }

    @JsonProperty("none")
    public List<Object> getNone() {
        return none;
    }

    @JsonProperty("none")
    public void setNone(List<Object> none) {
        this.none = none;
    }

    @JsonProperty("any")
    public List<SeleniunFWAxeAny> getAny() {
        return any;
    }

    @JsonProperty("any")
    public void setAny(List<SeleniunFWAxeAny> any) {
        this.any = any;
    }

    @JsonProperty("target")
    public List<String> getTarget() {
        return target;
    }

    @JsonProperty("target")
    public void setTarget(List<String> target) {
        this.target = target;
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
