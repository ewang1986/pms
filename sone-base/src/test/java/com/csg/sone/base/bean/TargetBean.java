package com.csg.sone.base.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * <p> Description:  SourceBean </p>
 * <pre> </pre>
 *
 * Copyright: © 2012-2017 . All rights reserved.
 * Company:
 *
 * @author William
 * @version 1.0
 */
public class TargetBean implements Serializable {
    private String strField;
    private Integer intField;
    private Long longField;
    private BigDecimal decimalField;
    private Date dateField;
    private Date dateTimeField;

    private List<TargetBean1> targetBean1;
    private List<TargetBean2> targetBean2;

    public String getStrField() {
        return strField;
    }

    public void setStrField(String strField) {
        this.strField = strField;
    }

    public Integer getIntField() {
        return intField;
    }

    public void setIntField(Integer intField) {
        this.intField = intField;
    }

    public Long getLongField() {
        return longField;
    }

    public void setLongField(Long longField) {
        this.longField = longField;
    }

    public BigDecimal getDecimalField() {
        return decimalField;
    }

    public void setDecimalField(BigDecimal decimalField) {
        this.decimalField = decimalField;
    }

    public Date getDateField() {
        return dateField;
    }

    public void setDateField(Date dateField) {
        this.dateField = dateField;
    }

    public Date getDateTimeField() {
        return dateTimeField;
    }

    public void setDateTimeField(Date dateTimeField) {
        this.dateTimeField = dateTimeField;
    }

    public List<TargetBean1> getTargetBean1() {
        return targetBean1;
    }

    public void setTargetBean1(List<TargetBean1> targetBean1) {
        this.targetBean1 = targetBean1;
    }

    public List<TargetBean2> getTargetBean2() {
        return targetBean2;
    }

    public void setTargetBean2(List<TargetBean2> targetBean2) {
        this.targetBean2 = targetBean2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TargetBean that = (TargetBean) o;
        return Objects.equals(strField, that.strField) &&
                Objects.equals(intField, that.intField) &&
                Objects.equals(longField, that.longField) &&
                Objects.equals(decimalField, that.decimalField) &&
                Objects.equals(dateField, that.dateField) &&
                Objects.equals(dateTimeField, that.dateTimeField) &&
                Objects.equals(targetBean1, that.targetBean1) &&
                Objects.equals(targetBean2, that.targetBean2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strField, intField, longField, decimalField, dateField, dateTimeField, targetBean1, targetBean2);
    }
}
