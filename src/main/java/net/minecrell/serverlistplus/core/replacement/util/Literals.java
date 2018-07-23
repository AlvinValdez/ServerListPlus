/*
 * ServerListPlus - https://git.io/slp
 * Copyright (C) 2014 Minecrell (https://github.com/Minecrell)
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package net.minecrell.serverlistplus.core.replacement.util;

import com.google.common.collect.Iterators;
import net.minecrell.serverlistplus.core.util.Helper;

import java.util.Iterator;

public final class Literals {
    private Literals() {}

    public static boolean find(String literal, String s) {
        return s.contains(literal);
    }

    public static String replace(String s, String literal, Object replacement) {
        if (replacement == null) return s;
        StringBuilder result = new StringBuilder(s.length());
        return replace(s, literal, result, 0, replacement) ? result.toString() : s;
    }

    private static boolean replace(String s, String literal, StringBuilder result, int pos, Object replacement) {
        if (replacement == null) return false;
        final int stringLength = s.length();

        int i = s.indexOf(literal, pos);
        if (i == -1) return false;

        final String replacementString = replacement.toString();
        final int replaceLength = literal.length();
        do {
            result.append(s, pos, i);
            pos = i + replaceLength;
            result.append(replacementString);

            if (pos == stringLength) break;
            i = s.indexOf(literal, pos);
        } while (i != -1);

        if (pos < stringLength)
            result.append(s, pos, stringLength);

        return true;
    }

    public static String replace(String s, String literal, Object... replacements) {
        return Helper.isNullOrEmpty(replacements) ? s : replace(s, literal, Iterators.forArray(replacements));
    }

    public static String replace(String s, String literal, Iterator<?> replacements) {
        return replace(s, literal, replacements, null);
    }

    public static String replace(String s, String literal, Iterator<?> replacements, Object others) {
        if (Helper.isNullOrEmpty(replacements)) return replace(s, literal, others);

        int i = s.indexOf(literal);
        if (i == -1) return s;

        final int stringLength = s.length();
        final StringBuilder result = new StringBuilder(stringLength);

        int pos = 0;
        final int replaceLength = literal.length();

        do {
            result.append(s, pos, i);
            pos = i + replaceLength;
            result.append(replacements.next());

            if (pos == stringLength) break;
            i = s.indexOf(literal, pos);
        } while (i != -1 && replacements.hasNext());

        if (i != -1 && replace(s, literal, result, pos, others)) return result.toString();
        if (pos < stringLength)
            result.append(s, pos, stringLength);

        return result.toString();
    }
}
