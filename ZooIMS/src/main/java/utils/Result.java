package utils;

import lombok.Data;

@Data
public class Result {
    private boolean flag;
    private Object data;
    private String mes;
    public Result(boolean flag, Object data) {
        this.flag = flag;
        this.data = data;
    }

    public Result(boolean flag, String mes) {
        this.flag = flag;
        this.mes = mes;
    }

    public Result(boolean flag) {
        this.flag = flag;
    }
}
