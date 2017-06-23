package com.nakanara.openapi1.apt.dao;


import javax.persistence.Entity;

/**
 * Created by steg on 2017-06-23.
 */

@Entity(name="tcCode")
public class TcCodeDao {

    private String code_type;

    private String code_id;

    private String code_name;

    private String code_used;

    private int code_order;



    public String getCode_type() {
        return code_type;
    }

    public void setCode_type(String code_type) {
        this.code_type = code_type;
    }

    public String getCode_id() {
        return code_id;
    }

    public void setCode_id(String code_id) {
        this.code_id = code_id;
    }

    public String getCode_name() {
        return code_name;
    }

    public void setCode_name(String code_name) {
        this.code_name = code_name;
    }

    public String getCode_used() {
        return code_used;
    }

    public void setCode_used(String code_used) {
        this.code_used = code_used;
    }

    public int getCode_order() {
        return code_order;
    }

    public void setCode_order(int code_order) {
        this.code_order = code_order;
    }

    @Override
    public String toString() {
        return "TcCodeDao{" +
                "code_type='" + code_type + '\'' +
                ", code_id='" + code_id + '\'' +
                ", code_name='" + code_name + '\'' +
                ", code_used='" + code_used + '\'' +
                ", code_order=" + code_order +
                '}';
    }
}
