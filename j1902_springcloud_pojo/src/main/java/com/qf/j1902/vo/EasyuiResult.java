package com.qf.j1902.vo;


import java.util.List;

/**
 * Created by Administrator on 2019/7/6.
 */

public class EasyuiResult {
    private long total; //总记录数
    private List<?> rows;//返回当前页的结果集

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "EasyuiResult{" +
                "total=" + total +
                ", rows=" + rows +
                '}';
    }
}
