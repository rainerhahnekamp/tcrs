package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.View;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * ModelAndView
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-06T22:03:33.269Z")

public class ModelAndView   {
  @JsonProperty("empty")
  private Boolean empty = null;

  @JsonProperty("model")
  private Object model = null;

  @JsonProperty("modelMap")
  @Valid
  private Map<String, Object> modelMap = null;

  @JsonProperty("reference")
  private Boolean reference = null;

  /**
   * Gets or Sets status
   */
  public enum StatusEnum {
    _100("100"),
    
    _101("101"),
    
    _102("102"),
    
    _103("103"),
    
    _200("200"),
    
    _201("201"),
    
    _202("202"),
    
    _203("203"),
    
    _204("204"),
    
    _205("205"),
    
    _206("206"),
    
    _207("207"),
    
    _208("208"),
    
    _226("226"),
    
    _300("300"),
    
    _301("301"),
    
    _302("302"),
    
    _303("303"),
    
    _304("304"),
    
    _305("305"),
    
    _307("307"),
    
    _308("308"),
    
    _400("400"),
    
    _401("401"),
    
    _402("402"),
    
    _403("403"),
    
    _404("404"),
    
    _405("405"),
    
    _406("406"),
    
    _407("407"),
    
    _408("408"),
    
    _409("409"),
    
    _410("410"),
    
    _411("411"),
    
    _412("412"),
    
    _413("413"),
    
    _414("414"),
    
    _415("415"),
    
    _416("416"),
    
    _417("417"),
    
    _418("418"),
    
    _419("419"),
    
    _420("420"),
    
    _421("421"),
    
    _422("422"),
    
    _423("423"),
    
    _424("424"),
    
    _426("426"),
    
    _428("428"),
    
    _429("429"),
    
    _431("431"),
    
    _451("451"),
    
    _500("500"),
    
    _501("501"),
    
    _502("502"),
    
    _503("503"),
    
    _504("504"),
    
    _505("505"),
    
    _506("506"),
    
    _507("507"),
    
    _508("508"),
    
    _509("509"),
    
    _510("510"),
    
    _511("511");

    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    @Override
    @JsonValue
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static StatusEnum fromValue(String text) {
      for (StatusEnum b : StatusEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
  }

  @JsonProperty("status")
  private StatusEnum status = null;

  @JsonProperty("view")
  private View view = null;

  @JsonProperty("viewName")
  private String viewName = null;

  public ModelAndView empty(Boolean empty) {
    this.empty = empty;
    return this;
  }

  /**
   * Get empty
   * @return empty
  **/
  @ApiModelProperty(value = "")


  public Boolean isEmpty() {
    return empty;
  }

  public void setEmpty(Boolean empty) {
    this.empty = empty;
  }

  public ModelAndView model(Object model) {
    this.model = model;
    return this;
  }

  /**
   * Get model
   * @return model
  **/
  @ApiModelProperty(value = "")


  public Object getModel() {
    return model;
  }

  public void setModel(Object model) {
    this.model = model;
  }

  public ModelAndView modelMap(Map<String, Object> modelMap) {
    this.modelMap = modelMap;
    return this;
  }

  public ModelAndView putModelMapItem(String key, Object modelMapItem) {
    if (this.modelMap == null) {
      this.modelMap = new HashMap<>();
    }
    this.modelMap.put(key, modelMapItem);
    return this;
  }

  /**
   * Get modelMap
   * @return modelMap
  **/
  @ApiModelProperty(value = "")


  public Map<String, Object> getModelMap() {
    return modelMap;
  }

  public void setModelMap(Map<String, Object> modelMap) {
    this.modelMap = modelMap;
  }

  public ModelAndView reference(Boolean reference) {
    this.reference = reference;
    return this;
  }

  /**
   * Get reference
   * @return reference
  **/
  @ApiModelProperty(value = "")


  public Boolean isReference() {
    return reference;
  }

  public void setReference(Boolean reference) {
    this.reference = reference;
  }

  public ModelAndView status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  **/
  @ApiModelProperty(value = "")


  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  public ModelAndView view(View view) {
    this.view = view;
    return this;
  }

  /**
   * Get view
   * @return view
  **/
  @ApiModelProperty(value = "")

  @Valid

  public View getView() {
    return view;
  }

  public void setView(View view) {
    this.view = view;
  }

  public ModelAndView viewName(String viewName) {
    this.viewName = viewName;
    return this;
  }

  /**
   * Get viewName
   * @return viewName
  **/
  @ApiModelProperty(value = "")


  public String getViewName() {
    return viewName;
  }

  public void setViewName(String viewName) {
    this.viewName = viewName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ModelAndView modelAndView = (ModelAndView) o;
    return Objects.equals(this.empty, modelAndView.empty) &&
        Objects.equals(this.model, modelAndView.model) &&
        Objects.equals(this.modelMap, modelAndView.modelMap) &&
        Objects.equals(this.reference, modelAndView.reference) &&
        Objects.equals(this.status, modelAndView.status) &&
        Objects.equals(this.view, modelAndView.view) &&
        Objects.equals(this.viewName, modelAndView.viewName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(empty, model, modelMap, reference, status, view, viewName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ModelAndView {\n");
    
    sb.append("    empty: ").append(toIndentedString(empty)).append("\n");
    sb.append("    model: ").append(toIndentedString(model)).append("\n");
    sb.append("    modelMap: ").append(toIndentedString(modelMap)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    view: ").append(toIndentedString(view)).append("\n");
    sb.append("    viewName: ").append(toIndentedString(viewName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

