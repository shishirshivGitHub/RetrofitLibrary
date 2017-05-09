
package android.learnretrofit_lib.model;

import java.util.List;

public class Example<R> {

    private Integer code;
    private List<Result> results = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }

}
