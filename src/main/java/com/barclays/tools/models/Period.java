package com.barclays.tools.models;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "effective_from", "rates" })
public class Period {

	@JsonProperty("effective_from")
	private String effectiveFrom;
	@JsonProperty("rates")
	private Rates rates;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("effective_from")
	public String getEffectiveFrom() {
		return effectiveFrom;
	}

	@JsonProperty("effective_from")
	public void setEffectiveFrom(String effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	@JsonProperty("rates")
	public Rates getRates() {
		return rates;
	}

	@JsonProperty("rates")
	public void setRates(Rates rates) {
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