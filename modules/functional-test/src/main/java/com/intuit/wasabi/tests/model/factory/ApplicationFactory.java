/*******************************************************************************
 * Copyright 2016 Intuit
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.intuit.wasabi.tests.model.factory;

import com.google.gson.GsonBuilder;
import com.intuit.wasabi.tests.library.util.Constants;
import com.intuit.wasabi.tests.model.Application;

/**
 * A factory for Applications.
 */
public class ApplicationFactory {

    /**
     * the primary application to keep it consistent across the board.
     */
    private static final Application defaultApplication = new Application(Constants.DEFAULT_PREFIX_APPLICATION + "PRIMARY");
    /**
     * Only used to create unique Application labels.
     */
    private static int internalId = 0;

    /**
     * Returns the default application.
     *
     * @return the default application
     */
    public static Application defaultApplication() {
        return defaultApplication;
    }

    /**
     * Creates a basic Application with the required default values.
     *
     * @return a default Application.
     */
    public static Application createApplication() {
        return new Application(Constants.DEFAULT_PREFIX_APPLICATION + String.valueOf(internalId++));
    }

    /**
     * Creates an Application from a JSON String.
     *
     * @param json the JSON String.
     * @return an Application represented by the JSON String.
     */
    public static Application createFromJSONString(String json) {
        return new GsonBuilder().create().fromJson(json, Application.class);
    }
}
