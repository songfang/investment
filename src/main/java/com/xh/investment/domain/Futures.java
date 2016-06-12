package com.xh.investment.domain;

public class Futures {
    private Long id;

    private String code;

    private String name;

    private String jys;

    private String type;

    private String date;

    private Double kpj;

    private Double zgj;

    private Double zdj;

    private Double zrsp;

    private Double mj;

    private Double maij;

    private Double zxj;

    private Double jsj;

    private Double zrjs;

    private Double ml;

    private Double mal;

    private Double ccl;

    private Double cjl;

    private String time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getJys() {
        return jys;
    }

    public void setJys(String jys) {
        this.jys = jys == null ? null : jys.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public Double getKpj() {
        return kpj;
    }

    public void setKpj(Double kpj) {
        this.kpj = kpj;
    }

    public Double getZgj() {
        return zgj;
    }

    public void setZgj(Double zgj) {
        this.zgj = zgj;
    }

    public Double getZdj() {
        return zdj;
    }

    public void setZdj(Double zdj) {
        this.zdj = zdj;
    }

    public Double getZrsp() {
        return zrsp;
    }

    public void setZrsp(Double zrsp) {
        this.zrsp = zrsp;
    }

    public Double getMj() {
        return mj;
    }

    public void setMj(Double mj) {
        this.mj = mj;
    }

    public Double getMaij() {
        return maij;
    }

    public void setMaij(Double maij) {
        this.maij = maij;
    }

    public Double getZxj() {
        return zxj;
    }

    public void setZxj(Double zxj) {
        this.zxj = zxj;
    }

    public Double getJsj() {
        return jsj;
    }

    public void setJsj(Double jsj) {
        this.jsj = jsj;
    }

    public Double getZrjs() {
        return zrjs;
    }

    public void setZrjs(Double zrjs) {
        this.zrjs = zrjs;
    }

    public Double getMl() {
        return ml;
    }

    public void setMl(Double ml) {
        this.ml = ml;
    }

    public Double getMal() {
        return mal;
    }

    public void setMal(Double mal) {
        this.mal = mal;
    }

    public Double getCcl() {
        return ccl;
    }

    public void setCcl(Double ccl) {
        this.ccl = ccl;
    }

    public Double getCjl() {
        return cjl;
    }

    public void setCjl(Double cjl) {
        this.cjl = cjl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time == null ? null : time.trim();
    }
}