package com.techelevator.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NutritionSearchDto {

    @JsonProperty("search_expression")
    private String searchExpression;
    private String timezone = "US/Eastern";


    public String getSearchExpression() {
        return searchExpression;
    }

    public void setSearch_expression(String searchExpression) {
        this.searchExpression = searchExpression;
    }

    //Parameters: method=foods.search&search_expression=toast&format=json
    public String toString() {
        return "{" +
                    "'query'=" + this.searchExpression + "\'," +
                    "'timezone'=" + "'US/Eastern'" + "\'," +
                "}";

    }
}
