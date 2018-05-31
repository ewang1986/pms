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
public class TargetBean1 implements Serializable {
    private String strField;
    private Integer intField;
    private Long longField;
    private BigDecimal decimalField;
    private Date dateField;
    private Date dateTimeField;

    private List<TargetBean11> targetBean11;
    private List<TargetBean12> targetBean12;

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

    public List<TargetBean11> getTargetBean11() {
        return targetBean11;
    }

    public void setTargetBean11(List<TargetBean11> targetBean11) {
        this.targetBean11 = targetBean11;
    }

    public List<TargetBean12> getTargetBean12() {
        return targetBean12;
    }

    public void setTargetBean12(List<TargetBean12> targetBean12) {
        this.targetBean12 = targetBean12;
    }
}
