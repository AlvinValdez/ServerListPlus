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

package net.minecrell.serverlistplus.bungee;

import net.md_5.bungee.api.plugin.Listener;
import net.md_5.bungee.api.plugin.Plugin;

import java.nio.file.Path;

public abstract class BungeePluginBase extends Plugin {

    public String getName() {
        return getDescription().getName();
    }

    public String getVersion() {
        return getDescription().getVersion();
    }

    public Path getPluginFolder() {
        return getDataFolder().toPath();
    }

    protected void registerListener(Listener listener) {
        getProxy().getPluginManager().registerListener(this, listener);
    }

    protected void unregisterListener(Listener listener) {
        getProxy().getPluginManager().unregisterListener(listener);
    }
}
