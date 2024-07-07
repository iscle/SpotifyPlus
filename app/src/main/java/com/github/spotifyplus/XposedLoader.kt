package com.github.spotifyplus

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge.log
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.XposedHelpers.findAndHookConstructor
import de.robv.android.xposed.XposedHelpers.findAndHookMethod
import de.robv.android.xposed.callbacks.XC_LoadPackage

class XposedLoader : IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        if (lpparam.packageName != "com.spotify.music") return

        // for version 8.9.52.552

        log("Hooking auth")

        findAndHookMethod(
            "p.jyb0",
            lpparam.classLoader,
            "a",
            object : XC_MethodHook() {
                override fun beforeHookedMethod(param: MethodHookParam) {
                    log("getting product state map")
                }

                override fun afterHookedMethod(param: MethodHookParam) {
                    val productStateMap = param.result as Map<String, String>
                    param.result = productStateMap.toMutableMap().apply {
                        this["audiobook-onboarding-completed"] = "0"
                        this["is-euterpe"] = "0"
                        this["remote-control"] = "6"
                        this["publish-activity"] = "1"
                        this["apply-child-content-restrictions"] = "0"
                        this["audio-preview-url-template"] = "https://p.scdn.co/mp3-preview/{id}"
                        this["incognito_mode_timeout"] = "21600"
                        this["ad-formats-preroll-video"] = "1"
                        this["type"] = "premium"
                        this["astro-auto-open"] = "0"
                        this["ab_recently_played_feature_time_filter_threshold"] = "com.spotify.gaia=30,driving-mode=120,spotify%3Ainternal%3Astartpage=30"
                        this["license-agreements"] = ""
                        this["astro-unboxing-entrypoint-enabled"] = "0"
                        this["publish-playlist"] = "1"
                        this["ab-mobile-iterable"] = "1"
                        this["buffering-strategy"] = "2"
                        this["expiry"] = "1"
                        this["has-audiobooks-subscription"] = "0"
                        this["ab-desktop-hide-follow"] = "0"
                        this["is-puffin"] = "0"
                        this["showcase-android"] = "1"
                        this["ab-collection-hide-unavailable-albums"] = "0"
                        this["capper-profile"] = ""
                        this["payments-initial-campaign"] = "default"
                        this["your-episodes-remove-unplayed-episodes"] = "never"
                        this["ab-ad-player-targeting"] = "1"
                        this["subscription-enddate"] = ""
                        this["social-session-free-tier"] = "0"
                        this["india-experience"] = "0"
                        this["dj-language"] = "not-set"
                        this["video-wifi-initial-bitrate"] = "800000"
                        this["can_use_superbird"] = "1"
                        this["ab-mobile-running-onlymanualmode"] = "only-manual"
                        this["playlist-annotations-markup"] = "0"
                        this["prefetch-keys"] = "1"
                        this["allow-override-internal-prefs"] = "0"
                        this["prefetch-window-max"] = "2"
                        this["send-email"] = "1"
                        this["ad-formats-video-takeover"] = "0"
                        this["has-blend-access"] = "1"
                        this["ab-collection-bookmark-model"] = "1"
                        this["pause-after"] = "0"
                        this["local-files-import"] = "0"
                        this["video-manifest-url"] = "https://spclient.wg.spotify.com/manifests/v6/{type}/sources/{source_id}/options/gzip+no_h264_high+partner=+supports_drm"
                        this["can-block-content"] = "1"
                        this["playlist-folders"] = "1"
                        this["obfuscate-restricted-tracks"] = "0"
                        this["your-episodes-remove-played-episodes"] = "not-set"
                        this["track-cap"] = "0"
                        this["guest-state"] = "not-guest"
                        this["restrict-playlist-collaboration"] = "0"
                        this["audiobook-onboarding-dismissed"] = "0"
                        this["ab-mobile-running-tempo-detection"] = "Enabled"
                        this["setup-headphones-changes"] = "0"
                        this["is_email_verified"] = "1"
                        this["shows-collection"] = "1"
                        this["enable-annotations-read"] = "1"
                        this["addon-hifi"] = "0"
                        this["mobile-browse"] = "1"
                        this["payments-locked-state"] = "0"
                        this["employee-free-opt-in"] = "0"
                        this["shows-collection-jam"] = "1"
                        this["ab-browse-music-tuesday"] = "1"
                        this["offline"] = "1"
                        this["streaming"] = "1"
                        this["fb-info-confirmation"] = "control"
                        this["allow-kids-account-selection"] = "0"
                        this["is-seadragon"] = "0"
                        this["audio-quality"] = "1"
                        this["dma-mode-enabled"] = "0"
                        this["wanted-licenses"] = ""
                        this["lastfm-session"] = ""
                        this["ab-mobile-discover"] = "0"
                        this["widevine-license-url"] = "https://spclient.wg.spotify.com/widevine-license/v1/video/license"
                        this["key-caching-max-count"] = "10000"
                        this["hifi-eligible"] = "0"
                        this["ad-session-persistence"] = "1"
                        this["video-initial-bitrate"] = "200000"
                        this["filter-explicit-content"] = "0"
                        this["ab-play-history"] = "0"
                        this["payment-state"] = ""
                        this["created_by_partner"] = ""
                        this["mobile-payment"] = "1"
                        this["key-caching-max-offline-seconds"] = "1800"
                        this["ugc-abuse-report-url"] = "https://support.spotify.com/abuse/?uri={uri}"
                        this["shuffle-algorithm"] = "1"
                        this["is-cheetara"] = "0"
                        this["use-pl3"] = "0"
                        this["image-url"] = "https://i.scdn.co/image/{file_id}"
                        this["exclude-from-marketing-and-advertising"] = "0"
                        this["restrict-branch-data-processing"] = "0"
                        this["restrict-settings-for-child"] = "0"
                        this["enable-autostart"] = "1"
                        this["metadata-link-lookup-modes"] = "0"
                        this["partner"] = ""
                        this["in-on-demand-ad-free-perk"] = "0"
                        this["shuffle"] = "0"
                        this["instant-search"] = "0"
                        this["allow-advertising-id-transmission"] = "1"
                        this["is-pigeon"] = "0"
                        this["instant-search-expand-sidebar"] = "0"
                        this["use-playlist-uris"] = "0"
                        this["user-profile-show-invitation-codes"] = "0"
                        this["ab-ad-requester"] = "1"
                        this["nft-disabled"] = "1"
                        this["ab-collection-union"] = "1"
                        this["libspotify"] = "1"
                        this["key-memory-cache-mode"] = "1:15,300"
                        this["high-bitrate"] = "1"
                        this["head-file-caching"] = "1"
                        this["radio"] = "1"
                        this["key-caching-auto-offline"] = "0"
                        this["ab-android-navigation-bar"] = "enabled"
                        this["is-standalone-audiobooks"] = "0"
                        this["explicit-content"] = "1"
                        this["video-cdn-sampling"] = "1"
                        this["ab-android-push-notifications"] = "1"
                        this["unrestricted"] = "1"
                        this["use-fb-publish-backend"] = "2"
                        this["has-been-premium-mini"] = "0"
                        this["disable-external-links-for-child"] = "0"
                        this["app-developer"] = "0"
                        this["enable-gapless"] = "1"
                        this["buffering-strategy-parameters"] = "0.8:0.2:0.0:0.0:0.0:0.0:1.0:10:10:2000:10000:10485760"
                        this["ab-playlist-extender"] = "1"
                        this["enable-crossfade"] = "1"
                        this["ad-persist-reward-time"] = "0"
                        this["public-toplist"] = "1"
                        this["network-operator-premium-activation"] = "1"
                        this["video-device-blacklisted"] = "0"
                        this["is-mermaid"] = "0"
                        this["shuffle-eligible"] = "1"
                        this["premium-unboxing-auto-open"] = "0"
                        this["collection"] = "1"
                        this["fb-grant-permission-local-render"] = "0"
                        this["backend-advised-bitrate"] = "1"
                        this["autoplay"] = "1"
                        this["catalogue"] = "premium"
                        this["storage-size-config"] = "10240,90,500,3"
                        this["dsa-mode-available"] = "1"
                        this["ads"] = "0"
                        this["head-files-url"] = "https://heads-fa-tls13.spotifycdn.com/head/{file_id}"
                        this["browse-overview-enabled"] = "1"
                        this["yl-kids-restricted-content"] = "0"
                        this["ab-collection-followed-artists-only"] = "1"
                        this["on-demand"] = "1"
                        this["premium-tab-lock"] = "0"
                        this["restrict-advertising-id-transmission"] = "0"
                        this["ap-resolve-pods"] = "0"
                        this["name"] = "Spotify Premium"
                        this["sidebar-navigation-enabled"] = "0"
                        this["dma-mode-available"] = "1"
                        this["loudness-levels"] = "1:-5.0,0.0,3.0:-2.0"
                        this["mobile-login"] = "1"
                        this["social-session"] = "1"
                        this["product-expiry"] = ""
                        this["hifi-optin-intent"] = "0"
                        this["is-mobile-only-tier"] = "0"
                        this["preferred-locale"] = "en"
                        this["license-acceptance-grace-days"] = "30"
                        this["pick-and-shuffle"] = "0"
                        this["prefetch-strategy"] = "18"
                        this["allow-connect-entry-points"] = "1"
                        this["taste-onboarding-signin-eligible"] = "0"
                        this["ugc-abuse-report"] = "1"
                        this["is-superstar"] = "0"
                        this["ab-watch-now"] = "0"
                        this["allow-live-events"] = "1"
                        this["financial-product"] = "pr:premium,tc:0,pa:,rt:v2_ES_default_full-price-premium-1m_10.99_EUR_default"
                        this["premium-mini"] = "0"
                        this["ab-collection-offline-mode"] = "0"
                        this["streaming-rules"] = ""
                        this["capping-bar-threshold"] = "3601"
                        this["ab-new-share-flow"] = "1"
                        this["video-keyframe-url"] = "http://keyframes-fa.cdn.spotify.com/keyframes/v1/sources/{source_id}/keyframe/heights/{height}/timestamps/{timestamp_ms}.jpg"
                        this["can-block-for-kids"] = "0"
                        this["mobile"] = "1"
                        this["disable-blocked-content"] = "0"
                        this["is_maybe_in_social_session"] = "0"
                        this["is-tuna"] = "0"
                        this["ab-mobile-startpage"] = "3"
                        this["dsa-mode-enabled"] = "0"
                        this["ab-hub-artist"] = "1"
                        this["ab-moments-experience"] = "0"
                        this["is-lingo-aurora"] = "0"
                        this["ab-mobile-social-feed"] = "1"
                        this["ab-test-group"] = "598"
                        this["is-marques"] = "0"
                        this["player-license"] = "premium"
                        this["premium-only-market-mobile"] = "0"
                        this["country_code"] = "ES"
                        this["com.spotify.madprops.delivered.by.ucs"] = "1"
                        this["com.spotify.madprops.use.ucs.product.state"] = "1"
                    }
                }
            }
        )

        log("Hooking SpotifyMediaBrowserService")

        findAndHookMethod(
            "com.spotify.music.libs.mediabrowserservice.SpotifyMediaBrowserService",
            lpparam.classLoader,
            "b",
            "java.lang.String",
            Int::class.javaPrimitiveType,
            "android.os.Bundle",
            object : XC_MethodHook() {
                override fun beforeHookedMethod(param: MethodHookParam) {
                    val clientPackageName = param.args[0] as String
                    val clientUid = param.args[1] as Int
                    log("SpotifyMediaBrowserService: onGetRoot: clientPackageName: $clientPackageName, clientUid: $clientUid")
                    param.args[0] = "com.google.android.projection.gearhead"
                }

                override fun afterHookedMethod(param: MethodHookParam) {
                    val root = param.result
                    log("SpotifyMediaBrowserService: onGetRoot: return: $root")
                }
            }
        )

        findAndHookMethod(
            "p.w3a",
            lpparam.classLoader,
            "c",
            "java.lang.String",
            object : XC_MethodHook() {
                override fun beforeHookedMethod(param: MethodHookParam) {
                    val clientPackageName = param.args[0] as String
                    log("SpotifyMediaBrowserService: onGetRoot: Patching first package name check")
                    param.result = true
                }
            }
        )

        findAndHookMethod(
            "p.uq1",
            lpparam.classLoader,
            "a",
            "android.content.Context",
            "p.d78",
            object : XC_MethodHook() {
                override fun beforeHookedMethod(param: MethodHookParam) {
                    val callerDescription = param.args[1]
                    log("SpotifyMediaBrowserService: onGetRoot: Patching second package name check")
                    param.result = true
                }
            }
        )
    }
}