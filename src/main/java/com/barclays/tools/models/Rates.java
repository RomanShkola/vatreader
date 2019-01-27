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
@JsonPropertyOrder({ "super_reduced", "reduced", "standard", "reduced1", "reduced2", "parking" })
public class Rates {

	@JsonProperty("super_reduced")
	private Double superReduced;
	@JsonProperty("reduced")
	private Double reduced;
	@JsonProperty("standard")
	private Double standard;
	@JsonProperty("reduced1")
	private Double reduced1;
	@JsonProperty("reduced2")
	private Double reduced2;
	@JsonProperty("parking")
	private Double parking;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("super_reduced")
	public Double getSuperReduced() {
		return superReduced;
	}

	@JsonProperty("super_reduced")
	public void setSuperReduced(Double superReduced) {
		this.superReduced = superReduced;
	}

	@JsonProperty("reduced")
	public Double getReduced() {
		return reduced;
	}

	@JsonProperty("reduced")
	public void setReduced(Double reduced) {
		this.reduced = reduced;
	}

	@JsonProperty("standard")
	public Double getStandard() {
		return standard;
	}

	@JsonProperty("standard")
	public void setStandard(Double standard) {
		this.standard = standard;
	}

	@JsonProperty("reduced1")
	public Double getReduced1() {
		return reduced1;
	}

	@JsonProperty("reduced1")
	public void setReduced1(Double reduced1) {
		this.reduced1 = reduced1;
	}

	@JsonProperty("reduced2")
	public Double getReduced2() {
		return reduced2;
	}

	@JsonProperty("reduced2")
	public void setReduced2(Double reduced2) {
		this.reduced2 = reduced2;
	}

	@JsonProperty("parking")
	public Double getParking() {
		return parking;
	}

	@JsonProperty("parking")
	public void setParking(Double parking) {
		this.parking = parking;
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