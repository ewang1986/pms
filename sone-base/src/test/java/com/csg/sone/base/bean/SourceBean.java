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
public class SourceBean implements Serializable {
    private String strField;
    private Integer intField;
    private Long longField;
    private BigDecimal decimalField;
    private Date dateField;
    private Date dateTimeField;

    private List<SourceBean1> sourceBean1;
    private List<SourceBean2> sourceBean2;

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

    public List<SourceBean1> getSourceBean1() {
        return sourceBean1;
    }

    public void setSourceBean1(List<SourceBean1> sourceBean1) {
        this.sourceBean1 = sourceBean1;
    }

    public List<SourceBean2> getSourceBean2() {
        return sourceBean2;
    }

    public void setSourceBean2(List<SourceBean2> sourceBean2) {
        this.sourceBean2 = sourceBean2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SourceBean that = (SourceBean) o;
        return Objects.equals(strField, that.strField) &&
                Objects.equals(intField, that.intField) &&
                Objects.equals(longField, that.longField) &&
                Objects.equals(decimalField, that.decimalField) &&
                Objects.equals(dateField, that.dateField) &&
                Objects.equals(dateTimeField, that.dateTimeField) &&
                Objects.equals(sourceBean1, that.sourceBean1) &&
                Objects.equals(sourceBean2, that.sourceBean2);
    }

    @Override
    public int hashCode() {
        return Objects.hash(strField, intField, longField, decimalField, dateField, dateTimeField, sourceBean1, sourceBean2);
    }
}
