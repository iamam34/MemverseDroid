package com.memverse.android.dagger.util;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Scope;

/**
 * A custom scope to be used by all fragment components.
 * In Dagger, an unscoped component cannot depend on a scoped component. Additionally, a component
 * with a specific scope cannot have a sub component with the same scope.
 * <p>
 * Created by amy on 29/12/17.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD})
public @interface FragmentScoped {
}