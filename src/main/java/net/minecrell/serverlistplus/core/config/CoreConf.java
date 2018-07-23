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

package net.minecrell.serverlistplus.core.config;

import net.minecrell.serverlistplus.core.config.help.Description;

@Description({
        "WARNING: Changes in this section can possibly break the plugin!",
        "Caches: Change the behaviour of the caches: http://goo.gl/oYVk0F",
})
public class CoreConf {
    public CachesConf Caches = new CachesConf();

    public static class CachesConf {
        public String Favicon = "maximumSize=2048,expireAfterWrite=6h";
        public String Request = "expireAfterWrite=2m";
    }
}
