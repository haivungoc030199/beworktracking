package com.bework.beworktracking.validation;

import java.util.List;

public interface Validator<T> {

    void validate(T t);

    void validateAll(List<T> ts);
}
