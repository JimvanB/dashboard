
package jim.spring.crypto.apis.wallets.coinbase.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "ending_before",
    "starting_after",
    "limit",
    "order",
    "previous_uri",
    "next_uri"
})
public class CoinbasePagination {

    @JsonProperty("ending_before")
    private Object endingBefore;
    @JsonProperty("starting_after")
    private Object startingAfter;
    @JsonProperty("limit")
    private Integer limit;
    @JsonProperty("order")
    private String order;
    @JsonProperty("previous_uri")
    private Object previousUri;
    @JsonProperty("next_uri")
    private Object nextUri;

    @JsonProperty("ending_before")
    public Object getEndingBefore() {
        return endingBefore;
    }

    @JsonProperty("ending_before")
    public void setEndingBefore(Object endingBefore) {
        this.endingBefore = endingBefore;
    }

    @JsonProperty("starting_after")
    public Object getStartingAfter() {
        return startingAfter;
    }

    @JsonProperty("starting_after")
    public void setStartingAfter(Object startingAfter) {
        this.startingAfter = startingAfter;
    }

    @JsonProperty("limit")
    public Integer getLimit() {
        return limit;
    }

    @JsonProperty("limit")
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    @JsonProperty("order")
    public String getOrder() {
        return order;
    }

    @JsonProperty("order")
    public void setOrder(String order) {
        this.order = order;
    }

    @JsonProperty("previous_uri")
    public Object getPreviousUri() {
        return previousUri;
    }

    @JsonProperty("previous_uri")
    public void setPreviousUri(Object previousUri) {
        this.previousUri = previousUri;
    }

    @JsonProperty("next_uri")
    public Object getNextUri() {
        return nextUri;
    }

    @JsonProperty("next_uri")
    public void setNextUri(Object nextUri) {
        this.nextUri = nextUri;
    }

}
