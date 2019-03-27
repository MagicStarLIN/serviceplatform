package com.lcl.serviceplatform.pojo;

public class Dic {
    private String type;
    private String name;
    private Integer value;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Dic{" +
                "type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", value=" + value +
                '}';
    }
}
