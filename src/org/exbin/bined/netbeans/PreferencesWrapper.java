/*
 * Copyright (C) ExBin Project
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
package org.exbin.bined.netbeans;

import org.exbin.bined.ideplugin.preferences.Preferences;
import java.util.prefs.BackingStoreException;
import org.openide.util.Exceptions;

/**
 * Wrapper for preferences
 *
 * @version 0.2.0 2019/01/12
 * @author ExBin Project (http://exbin.org)
 */
public class PreferencesWrapper implements Preferences {

    private final java.util.prefs.Preferences preferences;

    public PreferencesWrapper(java.util.prefs.Preferences preferences) {
        this.preferences = preferences;
    }

    @Override
    public void put(String key, String value) {
        preferences.put(key, value);
    }

    @Override
    public String get(String key, String def) {
        return preferences.get(key, def);
    }

    @Override
    public void remove(String key) {
        preferences.remove(key);
    }

    @Override
    public void putInt(String key, int value) {
        preferences.putInt(key, value);
    }

    @Override
    public int getInt(String key, int def) {
        return preferences.getInt(key, def);
    }

    @Override
    public void putLong(String key, long value) {
        preferences.putLong(key, value);
    }

    @Override
    public long getLong(String key, long def) {
        return preferences.getLong(key, def);
    }

    @Override
    public void putBoolean(String key, boolean value) {
        preferences.putBoolean(key, value);
    }

    @Override
    public boolean getBoolean(String key, boolean def) {
        return preferences.getBoolean(key, def);
    }

    @Override
    public void putFloat(String key, float value) {
        preferences.putFloat(key, value);
    }

    @Override
    public float getFloat(String key, float def) {
        return preferences.getFloat(key, def);
    }

    @Override
    public void putDouble(String key, double value) {
        preferences.putDouble(key, value);
    }

    @Override
    public double getDouble(String key, double def) {
        return preferences.getDouble(key, def);
    }

    @Override
    public void putByteArray(String key, byte[] value) {
        preferences.putByteArray(key, value);
    }

    @Override
    public byte[] getByteArray(String key, byte[] def) {
        return preferences.getByteArray(key, def);
    }

    @Override
    public void flush() {
        try {
            preferences.flush();
        } catch (BackingStoreException ex) {
            Exceptions.printStackTrace(ex);
        }
    }

    @Override
    public void sync() {
        try {
            preferences.sync();
        } catch (BackingStoreException ex) {
            Exceptions.printStackTrace(ex);
        }
    }
}