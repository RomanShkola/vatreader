package com.barclays.tools.readers;

import java.net.URL;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.barclays.tools.models.Rate;
import com.barclays.tools.models.VATData;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@Primary
public class VATReaderJson implements VATReader {

	private static final Logger logger = LoggerFactory.getLogger(VATReaderJson.class);

	private String url;
	private int numHighest;
	private int numLowest;

	@Override
	public void read() {

		ObjectMapper mapper = new ObjectMapper();
		try {
			logger.info("loading data from " + url);
			VATData data = mapper.readValue(new URL(url), VATData.class);

			String highestStandardVAT = getHighestStandardVAT(data).entrySet().stream().limit(numHighest)
					.map(entry -> entry.getKey() + " - " + entry.getValue()).collect(Collectors.joining(", "));
			logger.info(highestStandardVAT);

			String lowestStandardVAT = getLowestStandardVAT(data).entrySet().stream().limit(numLowest)
					.map(entry -> entry.getKey() + " - " + entry.getValue()).collect(Collectors.joining(", "));
			logger.info(lowestStandardVAT);

		} catch (Exception e) {
			logger.error(e.getMessage());
		}
	}

	private Map<String, Double> getHighestStandardVAT(VATData data) {

		logger.info(numHighest + " EU countries with the highest VAT:");
		Map<String, Double> map = data.getRates().stream().collect(Collectors.toMap(Rate::getName, r -> r.getPeriods()
				.stream().map(x -> x.getRates().getStandard()).max(Comparator.comparingDouble(Double::valueOf)).get()));

		map = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors
				.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));

		return map;
	}

	private Map<String, Double> getLowestStandardVAT(VATData data) {
		
		logger.info(numLowest + " EU countries with the lowest VAT:");
		Map<String, Double> map = data.getRates().stream().collect(Collectors.toMap(Rate::getName, r -> r.getPeriods()
				.stream().map(x -> x.getRates().getStandard()).min(Comparator.comparingDouble(Double::valueOf)).get()));

		map = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.naturalOrder())).collect(Collectors
				.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue, LinkedHashMap::new));
		return map;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getNumHighest() {
		return numHighest;
	}

	public void setNumHighest(int numHighest) {
		this.numHighest = numHighest;
	}

	public int getNumLowest() {
		return numLowest;
	}

	public void setNumLowest(int numLowest) {
		this.numLowest = numLowest;
	}

}
