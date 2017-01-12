/*
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package com.classfound.feedback.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;


/**
 * The model class that represents the application details.
 * Created by philic3 on 8/27/2016.
 */
@JsonPOJOBuilder
public class ApplicationModel {

    @JsonProperty(value = "applicationName")
    private String applicationName;

    @JsonProperty(value = "applicationKey")
    private String applicationKey;

    @JsonProperty(value = "applicationOwner")
    private String applicationOwner;

    public ApplicationModel (){}

    public ApplicationModel (String applicationName, String applicationKey, String applicationOwner) {
        this.applicationName = applicationName;
        this.applicationKey = applicationKey;
        this.applicationOwner = applicationOwner;
    }

    public String getApplicationName() {
        return applicationName;
    }

    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    public String getApplicationKey() {
        return applicationKey;
    }

    public void setApplicationKey(String applicationKey) {
        this.applicationKey = applicationKey;
    }

    public String getApplicationOwner() {
        return applicationOwner;
    }

    public void setApplicationOwner(String applicationOwner) {
        this.applicationOwner = applicationOwner;
    }
}
