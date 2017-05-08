/**
 * Copyright (c) 2017-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */

package com.facebook.litho.config;

import android.os.Build;

import com.facebook.litho.BuildConfig;
import com.facebook.yoga.YogaLogger;

/**
 * Configuration for the Components library.
 */
public class ComponentsConfiguration {

  public static YogaLogger YOGA_LOGGER;

  /**
   * Indicates whether this is an internal build.
   * Note that the implementation of {@link BuildConfig} that this class is compiled against may not
   * be the one that is included in the APK. See: <a
   * href="http://facebook.github.io/buck/rule/android_build_config.html">android_build_config</a>.
   */
  public static final boolean IS_INTERNAL_BUILD = BuildConfig.IS_INTERNAL_BUILD;

  /**
   * Option to enabled stetho debugging.
   * We default to `IS_INTERNAL_BUILD` which is false for release builds but
   * allow overriding at runtime.
   */
  public static boolean isStethoEnabled = BuildConfig.IS_INTERNAL_BUILD;

  /**
   * Debug option to highlight interactive areas in mounted components.
   */
  public static boolean debugHighlightInteractiveBounds = false;

  /**
   * Debug option to highlight mount bounds of mounted components.
   */
  public static boolean debugHighlightMountBounds = false;

  /**
   * Populates additional metadata to find mounted components at runtime. Defaults to the presence
   * of an <pre>IS_TESTING</pre> system property at startup but can be overridden at runtime.
   */
  public static boolean isEndToEndTestRun = System.getProperty("IS_TESTING") != null;

  /**
   * Indicates whether LayoutState should try to generate DisplayLists for Components that support
   * that.
   */
  public static volatile boolean shouldGenerateDisplayLists =
      Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;

  /**
   * Indicates whether LayoutState should queue LayoutOutputs for further generating DisplayLists
   * in the main thread.
   *
   * The difference of this one from `shouldGenerateDisplayLists` is that the latter
   * generates Display lists only when calculating layout and only when that happens in the main
   * thread. This flag will enable splitting up that operation into two parts, queueing outputs of
   * layout calculation (either in background thread or in main thread) and processing these outputs
   * later in the main thread.
   */
  public static boolean shouldPrefetchDisplayLists = false;

  /**
   * Use the new bootstrap ranges code instead of initializing all the items when the binder view
   * is measured (t12986103).
   */
  public static boolean bootstrapBinderItems = false;

  /**
   * Whether to use Object pooling via {@link com.facebook.litho.ComponentsPools}. This is switch
   * beacuse we are experimenting with turning off pooling to get a sense of what its impact is
   * in production.
   */
  public static volatile boolean usePooling = true;

  /**
   * Whether to enable incremental mount that operates directly from LithoView's methods.
   */
  public static boolean isIncrementalMountOnOffsetOrTranslationChangeEnabled = true;
}
