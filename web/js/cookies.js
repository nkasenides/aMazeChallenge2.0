class Cookies {

    //Declare your cookies here and access them using Cookies.MY_COOKIE
    static LEARN_ITEM_CHECK = "LEARN_ITEM_CHECK";
    static PERSONALIZE_ITEM_CHECK = "PERSONALIZE_ITEM_CHECK";
    static EDIT_CODE_ITEM_CHECK = "EDIT_CODE_ITEM_CHECK";
    static TRAINING_ITEM_CHECK = "TRAINING_ITEM_CHECK";
    static PLAY_ONLINE_ITEM_CHECK = "PLAY_ONLINE_ITEM_CHECK";
    static MAZE_DESIGNER_ITEM_CHECK = "MAZE_DESIGNER_ITEM_CHECK";
    static ABOUT_ITEM_CHECK = "ABOUT_ITEM_CHECK";

    static PREF_NAME = "PREF_NAME";
    static PREF_EMAIL = "PREF_EMAIL";
    static PREF_ICON = "PREF_ICON";
    static PREF_COLOR = "PREF_COLOR";

    //----------------------------------------------------------------------------------------------------------------//

    /**
     * Sets a cookie with a specific name, value and expiration time.
     * If a cookie with the same name already exists, the cookie is replaced.
     * @param cookieName The name of the cookie.
     * @param cookieValue The value of the cookie.
     */
    static setCookie(cookieName, cookieValue) {
        cookieValue += "";
        cookieValue = cookieValue.replace(/;/g, '%3B');
        const date = new Date();
        date.setTime(date.getTime() + (30*24*60*60*1000));
        const expires = "expires=" + date.toUTCString();
        document.cookie = cookieName + "=" + cookieValue + "; " + expires;
    }

    /**
     * Sets a cookie with a specific name, value and expiration time.
     * If a cookie with the same name already exists, the cookie is replaced.
     * @param cookieName The name of the cookie.
     * @param cookieValue The value of the cookie.
     * @param cookieExpirationDays The expiration time of the cookie.
     */
    static setCookieWithExpiration(cookieName, cookieValue, cookieExpirationDays) {
        cookieValue += "";
        cookieValue = cookieValue.replace(/;/g, '%3B');
        const date = new Date();
        date.setTime(date.getTime() + (cookieExpirationDays*24*60*60*1000));
        const expires = "expires=" + date.toUTCString();
        document.cookie = cookieName + "=" + cookieValue + "; " + expires;
    }

    /**
     * Returns a cookie's value or empty string if it does not exist.
     * @param cname The name of the cookie to get.
     * @returns {string | null}
     */
    static getCookie(cname) {
        const name = cname + "=";
        const cookieArray = document.cookie.split(';');
        for(let i = 0; i <cookieArray.length; i++) {
            let currentCookie = cookieArray[i];
            while (currentCookie.charAt(0) === ' ') currentCookie = currentCookie.substring(1);
            if (currentCookie.indexOf(name) === 0) return currentCookie.substring(name.length,currentCookie.length).replace(/%3B/g, ";");
        }
        return null;
    }

    /**
     * Returns true if cookie exists, false if it does not.
     * @param cname The name of the cookie to check.
     * @returns {boolean}
     */
    static cookieExists(cname) {
        return Cookies.getCookie(cname) != null;
    }

    /**
     * Deletes a given cookie.
     * @param cookieName The name of the cookie to delete.
     */
    static deleteCookie(cookieName) {
        const cookieValue = "";
        const date = new Date();
        date.setTime(date.getTime() - 1);
        const expires = "expires="+ date.toUTCString();
        document.cookie = cookieName + "=" + cookieValue + "; " + expires;
    }

    /**
     * Resets the values of all cookies (deletes all cookies for this site).
     */
    static resetCookies() {
        const cookies = document.cookie.split(";");
        for (let i = 0; i < cookies.length; i++) {
            let cookie = cookies[i];
            let eqPos = cookie.indexOf("=");
            let name = eqPos > -1 ? cookie.substr(0, eqPos) : cookie;
            document.cookie = name + "=;expires=Thu, 01 Jan 1970 00:00:00 GMT";
        }
    }

}