package com.barclays.tools.models;

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
@JsonPropertyOrder({ "details", "version", "rates" })
public class VATData {

	@JsonProperty("details")
	private String details;
	@JsonProperty("version")
	private Object version;
	@JsonProperty("rates")
	private List<Rate> rates = null;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("details")
	public String getDetails() {
		return details;
	}

	@JsonProperty("details")
	public void setDetails(String details) {
		this.details = details;
	}

	@JsonProperty("version")
	public Object getVersion() {
		return version;
	}

	@JsonProperty("version")
	public void setVersion(Object version) {
		this.version = version;
	}

	@JsonProperty("rates")
	public List<Rate> getRates() {
		return rates;
	}

	@JsonProperty("rates")
	public void setRates(List<Rate> rates) {
		this.rates = rates;
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