package test.order.domain.dto.billing;

/**
 * Created by yongjunjung on 2017. 2. 24..
 */
public class BillingRequestReturnDto {

    private String requestUrl;
    private String pgModule;

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    public String getPgModule() {
        return pgModule;
    }

    public void setPgModule(String pgModule) {
        this.pgModule = pgModule;
    }
}
