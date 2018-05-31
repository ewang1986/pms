package com.csg.sone.base.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
public class SourceBean1 implements Serializable {
    private String strField;
    private Integer intField;
    private Long longField;
    private BigDecimal decimalField;
    private Date dateField;
    private Date dateTimeField;

    private List<SourceBean11> sourceBean11;
    private List<SourceBean12> sourceBean12;

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

    public List<SourceBean11> getSourceBean11() {
        return sourceBean11;
    }

    public void setSourceBean11(List<SourceBean11> sourceBean11) {
        this.sourceBean11 = sourceBean11;
    }

    public List<SourceBean12> getSourceBean12() {
        return sourceBean12;
    }

    public void setSourceBean12(List<SourceBean12> sourceBean12) {
        this.sourceBean12 = sourceBean12;
    }
}
