import grails.util.GrailsNameUtils
import org.springframework.core.io.FileSystemResource

/*
* Copyright 2004-2005 the original author or authors.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

/**
 * Gant script that creates a Grails domain class
 *
 * @author Graeme Rocher
 *
 * @since 0.4
 */

includeTargets << grailsScript("_GrailsInit")
includeTargets << grailsScript("_GrailsCreateArtifacts")

target ('default': "Creates a new MongoDB mapped class") {
  depends(checkVersion, parseArguments)

  promptForName(type: "MongoDB class")

  def name = argsMap["params"][0]
  createArtifact(name: name, suffix: "", type: "MongoDBClass", path: "grails-app/mongo")
  createIntegrationTest(name: name, suffix: "")
}
