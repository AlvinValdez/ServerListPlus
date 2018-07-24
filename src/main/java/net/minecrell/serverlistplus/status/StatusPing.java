/*
 * ServerListPlus
 * Copyright (C) 2017 Minecrell <https://github.com/Minecrell>
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

package net.minecrell.serverlistplus.status;

import java.util.List;

import javax.annotation.Nullable;

public interface StatusPing extends StatusRequest {

    String getDescription();
    void setDescription(String description);

    boolean isHidePlayers();
    void setHidePlayers(boolean hidePlayers);

    int getOnlinePlayers();
    void setOnlinePlayers(int online);

    int getMaxPlayers();
    void setMaxPlayers(int max);

    List<PlayerProfile> getPlayerProfiles();
    void setPlayerProfiles(List<PlayerProfile> profiles);

    String getVersion();
    void setVersion(String version);

    int getProtocolVersion();
    void setProtocolVersion(int protocolVersion);

    @Nullable
    Favicon getFavicon();
    void setFavicon(@Nullable Favicon favicon) throws UnsupportedOperationException;

}
