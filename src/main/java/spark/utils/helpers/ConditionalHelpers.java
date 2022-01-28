package spark.utils.helpers; /**
 * Copyright (c) 2012-2015 Edgar Espina
 *
 * This file is part of Handlebars.java.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


import static org.apache.commons.lang3.Validate.isTrue;

import java.io.IOException;
import java.util.Objects;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;
import com.github.jknack.handlebars.TagType;

/**
 * Implementation of equals, greater, lessThan, and, or, etc.. operators.
 *
 * @author edgar
 * @since 4.0.7
 */
public enum ConditionalHelpers implements Helper<Object> {

    /**
     * Test if two elements are equals. Usage:
     *
     * Render 'yes' or 'no':
     * <pre>
     *   {{#eq a b}}
     *     yes
     *   {{else}}
     *     no
     *   {{/eq}}
     * </pre>
     *
     * Render 'true' or 'false':
     * <pre>
     *   {{eq a b}}
     * </pre>
     *
     * Render 'y' or 'n':
     * <pre>
     *   {{eq a b yes='y' no='n'}}
     * </pre>
     */
    eq {
        @Override public Object apply(final Object a, final Options options) throws IOException {
            Object b = options.param(0, null);
            boolean result = eq(a, b);
            if (options.tagType == TagType.SECTION) {
                return result ? options.fn() : options.inverse();
            }
            return result
                    ? options.hash("yes", true)
                    : options.hash("no", false);
        }
    },

    /**
     * Test if two elements are NOT equals. Usage:
     *
     * Render 'yes' or 'no':
     * <pre>
     *   {{#neq a b}}
     *     yes
     *   {{else}}
     *     no
     *   {{/neq}}
     * </pre>
     *
     * Render 'true' or 'false':
     * <pre>
     *   {{neq a b}}
     * </pre>
     *
     * Render 'y' or 'n':
     * <pre>
     *   {{neq a b yes='y' no='n'}}
     * </pre>
     */
    neq {
        @Override public Object apply(final Object a, final Options options) throws IOException {
            Object b = options.param(0, null);
            boolean result = !eq(a, b);
            if (options.tagType == TagType.SECTION) {
                return result ? options.fn() : options.inverse();
            }
            return result
                    ? options.hash("yes", true)
                    : options.hash("no", false);
        }
    },

    /**
     * Greater operator (arguments must be {@link Comparable} elements. Usage:
     *
     * Render 'yes' or 'no':
     * <pre>
     *   {{#gt a b}}
     *     yes
     *   {{else}}
     *     no
     *   {{/gt}}
     * </pre>
     *
     * Render 'true' or 'false':
     * <pre>
     *   {{gt a b}}
     * </pre>
     *
     * Render 'y' or 'n':
     * <pre>
     *   {{neq a b yes='y' no='n'}}
     * </pre>
     */
    gt {
        @Override public Object apply(final Object a, final Options options) throws IOException {
            boolean result = cmp(a, options.param(0, null)) > 0;
            if (options.tagType == TagType.SECTION) {
                return result ? options.fn() : options.inverse();
            }
            return result
                    ? options.hash("yes", true)
                    : options.hash("no", false);
        }
    },

    /**
     * Greater or equal operator (arguments must be {@link Comparable} elements. Usage:
     *
     * Render 'yes' or 'no':
     * <pre>
     *   {{#gte a b}}
     *     yes
     *   {{else}}
     *     no
     *   {{/gte}}
     * </pre>
     *
     * Render 'true' or 'false':
     * <pre>
     *   {{gte a b}}
     * </pre>
     *
     * Render 'y' or 'n':
     * <pre>
     *   {{gte a b yes='y' no='n'}}
     * </pre>
     */
    gte {
        @Override public Object apply(final Object a, final Options options) throws IOException {
            boolean result = cmp(a, options.param(0, null)) >= 0;
            if (options.tagType == TagType.SECTION) {
                return result ? options.fn() : options.inverse();
            }
            return result
                    ? options.hash("yes", true)
                    : options.hash("no", false);
        }
    },

    /**
     * Less than operator (arguments must be {@link Comparable} elements. Usage:
     *
     * Render 'yes' or 'no':
     * <pre>
     *   {{#lt a b}}
     *     yes
     *   {{else}}
     *     no
     *   {{/lt}}
     * </pre>
     *
     * Render 'true' or 'false':
     * <pre>
     *   {{lt a b}}
     * </pre>
     *
     * Render 'y' or 'n':
     * <pre>
     *   {{lt a b yes='y' no='n'}}
     * </pre>
     */
    lt {
        @Override public Object apply(final Object a, final Options options) throws IOException {
            boolean result = cmp(a, options.param(0, null)) < 0;
            if (options.tagType == TagType.SECTION) {
                return result ? options.fn() : options.inverse();
            }
            return result
                    ? options.hash("yes", true)
                    : options.hash("no", false);
        }
    },

    /**
     * Less or equal operator (arguments must be {@link Comparable} elements. Usage:
     *
     * Render 'yes' or 'no':
     * <pre>
     *   {{#lte a b}}
     *     yes
     *   {{else}}
     *     no
     *   {{/lte}}
     * </pre>
     *
     * Render 'true' or 'false':
     * <pre>
     *   {{lte a b}}
     * </pre>
     *
     * Render 'y' or 'n':
     * <pre>
     *   {{lte a b yes='y' no='n'}}
     * </pre>
     */
    lte {
        @Override public Object apply(final Object a, final Options options) throws IOException {
            boolean result = cmp(a, options.param(0, null)) <= 0;
            if (options.tagType == TagType.SECTION) {
                return result ? options.fn() : options.inverse();
            }
            return result
                    ? options.hash("yes", true)
                    : options.hash("no", false);
        }
    },

    /**
     * And operator.
     *
     * Truthiness of arguments is determined by {@link Handlebars.Utils#isEmpty(Object)}, so this
     * helper can be used with non-boolean values.
     *
     * Usage:
     *
     * Render 'yes' or 'no':
     * <pre>
     *   {{#and a b}}
     *     yes
     *   {{else}}
     *     no
     *   {{/and}}
     * </pre>
     *
     * Multiple arguments are supported too:
     * <pre>
     *   {{#and a b c d}}
     *     yes
     *   {{else}}
     *     no
     *   {{/and}}
     * </pre>
     *
     * Render 'true' or 'false':
     * <pre>
     *   {{and a b}}
     * </pre>
     *
     * Render 'y' or 'n':
     * <pre>
     *   {{and a b yes='y' no='n'}}
     * </pre>
     */
    and {
        @Override public Object apply(final Object context, final Options options) throws IOException {
            boolean result = !Handlebars.Utils.isEmpty(context);
            if (result) {
                for (int i = 0; i < options.params.length && result; i++) {
                    result = !Handlebars.Utils.isEmpty(options.params[i]);
                }
            }
            if (options.tagType == TagType.SECTION) {
                return result ? options.fn() : options.inverse();
            }
            return result
                    ? options.hash("yes", true)
                    : options.hash("no", false);
        }
    },

    /**
     * Or operator.
     *
     * Truthiness of arguments is determined by {@link Handlebars.Utils#isEmpty(Object)}, so this
     * helper can be used with non-boolean values.
     *
     * Usage:
     *
     * Render 'yes' or 'no':
     * <pre>
     *   {{#or a b}}
     *     yes
     *   {{else}}
     *     no
     *   {{/or}}
     * </pre>
     *
     * Multiple arguments are supported too:
     * <pre>
     *   {{#or a b c d}}
     *     yes
     *   {{else}}
     *     no
     *   {{/or}}
     * </pre>
     *
     * Render 'true' or 'false':
     * <pre>
     *   {{or a b}}
     * </pre>
     *
     * Render 'y' or 'n':
     * <pre>
     *   {{or a b yes='y' no='n'}}
     * </pre>
     */
    or {
        @Override public Object apply(final Object context, final Options options) throws IOException {
            boolean result = !Handlebars.Utils.isEmpty(context);
            if (!result) {
                int i = 0;
                while (!result && i < options.params.length) {
                    result = !Handlebars.Utils.isEmpty(options.params[i++]);
                }
            }
            if (options.tagType == TagType.SECTION) {
                return result ? options.fn() : options.inverse();
            }
            return result
                    ? options.hash("yes", true)
                    : options.hash("no", false);
        }
    },

    /**
     * Not operator.
     *
     * Truthiness of arguments is determined by {@link Handlebars.Utils#isEmpty(Object)}, so this
     * helper can be used with non-boolean values.
     *
     * Usage:
     *
     * Render 'yes' or 'no':
     * <pre>
     *   {{#not a}}
     *     yes
     *   {{else}}
     *     no
     *   {{/not}}
     * </pre>
     *
     * Render 'true' or 'false':
     * <pre>
     *   {{not a}}
     * </pre>
     *
     * Render 'y' or 'n':
     * <pre>
     *   {{not a yes='y' no='n'}}
     * </pre>
     */
    not {
        @Override public Object apply(final Object context, final Options options) throws IOException {
            boolean result = Handlebars.Utils.isEmpty(context);
            if (options.tagType == TagType.SECTION) {
                return result ? options.fn() : options.inverse();
            }
            return result
                    ? options.hash("yes", true)
                    : options.hash("no", false);
        }
    };

    /**
     * Compare to object as comparables.
     *
     * @param a A comparable object.
     * @param b Another comparable object.
     * @return Int.
     */
    protected int cmp(final Object a, final Object b) {
        try {
            isTrue(a instanceof Comparable, "Not a comparable: " + a);
            isTrue(b instanceof Comparable, "Not a comparable: " + b);
            return ((Comparable) a).compareTo(b);
        } catch (ClassCastException x) {
            return Double.compare(toDoubleOrError(a, x), toDoubleOrError(b, x));
        }
    }

    /**
     * Compare two values. Number equality are treated as equals on they are like: 2 vs 2.0
     *
     * @param a First value.
     * @param b Second value.
     * @return True when equals.
     */
    protected boolean eq(final Object a, final Object b) {
        boolean value = Objects.equals(a, b);
        if (!value) {
            if (a instanceof Number && b instanceof Number) {
                // int vs double: 2 vs 2.0
                return ((Number) a).doubleValue() == ((Number) b).doubleValue();
            }
        }
        return value;
    }

    /**
     * Generate double from value or throw existing exception.
     * @param value Value to cast.
     * @param x Exception.
     * @return Double.
     */
    private double toDoubleOrError(final Object value, final RuntimeException x) {
        if (value instanceof Double) {
            return (Double) value;
        }
        if (value instanceof Number) {
            return ((Number) value).doubleValue();
        }
        throw x;
    }
}