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

package net.minecrell.serverlistplus.core.config.io;

import net.minecrell.serverlistplus.core.util.Helper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public final class IOHelper {
    private IOHelper() {}

    public static final Charset CHARSET = StandardCharsets.UTF_8;

    public static List<String> readLines(InputStream in) throws IOException {
        if (in == null) return null;
        BufferedReader reader = newBufferedReader(in);
        String line; List<String> result = new ArrayList<>();
        // Add all lines to the result list
        while ((line = reader.readLine()) != null)
            result.add(line);
        return result;
    }

    public static BufferedReader newBufferedReader(InputStream in) {
        return new BufferedReader(new InputStreamReader(in, CHARSET));
    }

    public static String[] readLineArray(InputStream in) throws IOException {
        return Helper.toStringArray(readLines(in));
    }

    public static BufferedReader newBufferedReader(Path path) throws IOException {
        return Files.newBufferedReader(path, CHARSET);
    }

    public static BufferedWriter newBufferedWriter(Path path) throws IOException {
        return Files.newBufferedWriter(path, CHARSET);
    }
}
