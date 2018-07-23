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

package net.minecrell.serverlistplus.core.util;

import com.google.common.base.Preconditions;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Path;
import java.nio.file.PathMatcher;

public class PathMatcherFilter implements DirectoryStream.Filter<Path> {
    private final PathMatcher matcher;

    public PathMatcherFilter(PathMatcher matcher) {
        this.matcher = Preconditions.checkNotNull(matcher, "matcher");
    }

    @Override
    public boolean accept(Path entry) throws IOException {
        return matcher.matches(entry.getFileName());
    }
}
