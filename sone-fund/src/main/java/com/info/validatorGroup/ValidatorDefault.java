package com.info.validatorGroup;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

/**
 * 定义验证所有的分组
 * @author v-dongdm
 *
 */
@GroupSequence({Default.class,ValidatorAdd.class,ValidatorEdit.class})
public interface ValidatorDefault {

}
