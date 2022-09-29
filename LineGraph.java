/*
 *
 *  * Copyright (c) 2022.  - All Rights Reserved
 *  *  * Unauthorized copying or redistribution of this file in source and binary forms via any medium
 *  *  * is strictly prohibited-
 *  *  * @Author -Dushyant.
 *
 */

package com.azuga.training;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.apache.log4j.Logger;

/**
 * This class generate Line graph of past 7 days of price variation of cardano.
 */
public class LineGraph {

    public static final Logger logger = Logger.getLogger(LineGraph.class);

    public static void main(String[] args) throws IOException, InterruptedException {
        LineGraph myobj = new LineGraph();
        myobj.lineGraph();

    }

    public void lineGraph() {
        //fetch data

        String url = "https://api.coingecko.com/api/v3/coins/cardano/market_chart?vs_currency=usd&days=7&interval=daily";
        logger.info("Cryto API is fetching for the url " + url);
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        HttpClient client = HttpClient.newBuilder().build();
        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
        JSONObject jsonObject = new JSONObject(response.body());
        JSONArray jsonArray = jsonObject.getJSONArray("prices");        //fetching prices object values
        logger.info("Getting json array of cardano prices");
        XYSeries xySeries = new XYSeries("Cardano");
        for (int i = 0; i < jsonArray.length(); i++) {
            String[] a = jsonArray.get(i).toString().replace("[", "").replace("]", "").split(",");
            logger.debug("getting coin value from json array  " + a[1]);
            xySeries.add(i + 1, Float.valueOf(a[1]));
        }
        logger.info("taking the value of 1 cardano coin on each day");
        XYSeriesCollection dataset = new XYSeriesCollection(xySeries);
        JFreeChart chart = ChartFactory.createXYLineChart("Past 7 days price of cardano",
                "Days", "Prices in USD", dataset, PlotOrientation.VERTICAL, true, true, false);
        try {
            ChartUtils.saveChartAsJPEG(new File("/Users/azuga/Desktop/LineChart.jpeg"), chart, 500, 300);
            // System.out.println("Line Chart created");
            logger.info("graph for cardano coin price created successfully");
        } catch (Exception e) {
            logger.error("Graph is not created of cardano due to path provided is wrong");
        }


    }
}
