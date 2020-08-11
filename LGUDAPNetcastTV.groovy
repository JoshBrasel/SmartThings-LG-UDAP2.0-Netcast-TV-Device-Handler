/*
* LG UDAP2.0 (Netcast) TV SmartThings Device Handler (SmartThings Classic Only)
*
* Configuration Steps:
*     1. Assign the TV a static IP address on your router
*     2. Turn the TV ON
*     3. Add this Device Handler on your SmartThings HUB and publish it
*     4. Add the Device to SmartThings
*         Type = LG UDAP 2.0 (Netcast) TV
*         Device Network ID = (Hex of IP address and port in the form of 00000000:0000) (i.e. 10.0.1.220:80 is 0A0001DC:0050)
*           *Note: You can find a converter on the Internet
*     5. Set the Device Preferences
*         tvIP = IP Address of the TV (with decimals)
*         tvPort = 8080 (typically 8080, only enter a different value if you know it is different)
*     6. Launch SmartThings (Classic) and navigate to the Device UI
*     7. Press the "Show Key" button in the bottom right corner (this should display a message on the screen with the TV Pairing Key)
*     8. Update the Device Preferences
*         tvPairingKey = (TV Pairing Key from step 7)
*     9. In SmartThings (Classic) navigate to the Device UI and press the Refresh button
*    10. Install Pollster (https://github.com/statusbits/smartthings/blob/master/Pollster.md) and configure the Device to poll every 5 minutes
*/

metadata {
    definition (name: "LG UDAP 2.0 (Netcast) TV (v1.1)", namespace: "Brasel", author: "Josh Brasel"){
        capability "Switch"
        capability "Polling"
        capability "Refresh"
        capability "Switch Level"
    
        command "powerButton"
        command "refreshButton"
        command "volumeUpButton"
        command "volumeDownButton"
        command "muteButton"
        command "channelUpButton"
        command "channelDownButton"
        command "homeButton"
        command "settingsButton"
        command "showKeyButton"
        command "inputButton"
        command "returnButton"
        command "exitButton"
        command "upButton"
        command "rightButton"
        command "downButton"
        command "leftButton"
        command "centerButton"
        command "playButton"
        command "pauseButton"
        command "rewindButton"
        command "fastforwardButton"
        command "stopButton"
        command "netflixButton"
        command "vuduButton"
        command "youTubeButton"
        command "blueButton"
        command "greenButton"
        command "redButton"
        command "yellowButton"
    }

    tiles(scale:2){
        multiAttributeTile(name:"mainTile", type:"generic", width:6, height:4){
            tileAttribute("device.switch", key: "PRIMARY_CONTROL"){
                attributeState "off", label: '${currentValue}', action: "switch.on", icon: "st.Electronics.electronics18", backgroundColor: "#ffffff", nextState: "off"
                attributeState "on", label: '${currentValue}', action: "switch.off", icon: "st.Electronics.electronics18", backgroundColor: "#00a0dc", nextState: "off"}
            tileAttribute("device.input", key: "SECONDARY_CONTROL"){
                attributeState "input", label: '${currentValue}'}
            tileAttribute("device.level", key: "SLIDER_CONTROL"){
                attributeState "level", action:"setLevel", icon: 'st.Entertainment.entertainment15',  defaultState: "true"}
        }
        standardTile("powerButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"Power", action:"powerButton", icon:"st.samsung.da.RC_ic_power"}
        standardTile("refreshButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"Refresh", action:"refresh", icon:"st.secondary.refresh-icon"}
        standardTile("volumeUpButton", "device.switch", inactiveLabel: false, height: 2, width: 2, decoration: "flat"){
            state "default", label:"", action:"volumeUpButton", icon:"st.samsung.da.oven_ic_plus"}
        standardTile("volumeDownButton", "device.switch", inactiveLabel: false, height: 2, width: 2, decoration: "flat"){
            state "default", label:"", action:"volumeDownButton", icon:"st.samsung.da.oven_ic_minus"}
        valueTile("muteButton", "device.mute", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "true", label:"Mute", action:"muteButton", icon: "st.custom.sonos.muted"//, nextState: "false"
            state "false", label:"Mute", action:"muteButton", icon: "st.custom.sonos.unmuted"}//, nextState: "true"}            
        standardTile("channelUpButton", "device.switch", inactiveLabel: false, height: 2, width: 2, decoration: "flat"){
            state "default", label:"", action:"channelUpButton", icon:"st.samsung.da.oven_ic_up"}
        standardTile("channelDownButton", "device.switch", inactiveLabel: false, height: 2, width: 2, decoration: "flat"){
            state "default", label:"", action:"channelDownButton", icon:"st.samsung.da.oven_ic_down"}
        standardTile("homeButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"Home", action:"homeButton", icon:"st.Home.home2"}
        standardTile("settingsButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"Settings", action:"settingsButton", icon:"st.secondary.preferences"}
        standardTile("showKeyButton", "device.switch", inactiveLabel: false, height: 2, width: 2, decoration: "flat"){
            state "default", label:"Show Key", action:"showKeyButton", icon:"st.security.alarm.on"}  
        standardTile("inputButton", "device.switch", inactiveLabel: false, height: 2, width: 2, decoration: "flat"){
            state "default", label:"Input", action:"inputButton", icon:"https://raw.githubusercontent.com/joshbrasel/SmartThingsCustomIcons/master/Input.png"}
        standardTile("returnButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"Return", action:"returnButton", icon:"https://raw.githubusercontent.com/joshbrasel/SmartThingsCustomIcons/master/Return.png"}
        standardTile("exitButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"Exit", action:"exitButton", icon:"st.samsung.da.washer_ic_cancel"}
        standardTile("upButton", "device.switch", inactiveLabel: false, height: 2, width: 2, decoration: "flat"){
            state "default", label:"", action:"upButton", icon:"st.thermostat.thermostat-up"}
        standardTile("rightButton", "device.switch", inactiveLabel: false, height: 2, width: 2, decoration: "flat"){
            state "default", label:"", action:"rightButton", icon:"st.thermostat.thermostat-right"}
        standardTile("downButton", "device.switch", inactiveLabel: false, height: 2, width: 2, decoration: "flat"){
            state "default", label:"", action:"downButton", icon:"st.thermostat.thermostat-down"}
        standardTile("leftButton", "device.switch", inactiveLabel: false, height: 2, width: 2, decoration: "flat"){
            state "default", label:"", action:"leftButton", icon:"st.thermostat.thermostat-left"}
        standardTile("centerButton", "device.switch", inactiveLabel: false, height: 2, width: 2, decoration: "flat"){
            state "default", label:"", action:"centerButton", icon:"st.illuminance.illuminance.dark"}
        standardTile("playButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"", action:"playButton", icon:"st.sonos.play-btn"}
        standardTile("pauseButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"", action:"pauseButton", icon:"st.sonos.pause-btn"}
        standardTile("rewindButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"", action:"rewindButton", icon:"st.sonos.previous-btn"}
        standardTile("fastforwardButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"", action:"fastforwardButton", icon:"st.sonos.next-btn"}
        standardTile("stopButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"", action:"stopButton", icon:"st.sonos.stop-btn"}
        standardTile("netflixButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"", action:"netflixButton", icon:"https://raw.githubusercontent.com/joshbrasel/SmartThingsCustomIcons/master/Netflix.png"}
        standardTile("vuduButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"", action:"vuduButton", icon:"https://raw.githubusercontent.com/joshbrasel/SmartThingsCustomIcons/master/Vudu.png"}
        standardTile("youTubeButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"", action:"youTubeButton", icon:"https://raw.githubusercontent.com/joshbrasel/SmartThingsCustomIcons/master/YouTube.png"}
        standardTile("blueButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"", action:"stopButton", icon:"https://raw.githubusercontent.com/joshbrasel/SmartThingsCustomIcons/master/Blue.png"}
        standardTile("greenButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"", action:"greenButton", icon:"https://raw.githubusercontent.com/joshbrasel/SmartThingsCustomIcons/master/Green.png"}        
        standardTile("redButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"", action:"redButton", icon:"https://raw.githubusercontent.com/joshbrasel/SmartThingsCustomIcons/master/Red.png"}
        standardTile("yellowButton", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"", action:"yellowButton", icon:"https://raw.githubusercontent.com/joshbrasel/SmartThingsCustomIcons/master/Yellow.png"}  
        standardTile("emptyButtonLarge", "device.switch", inactiveLabel: false, height: 2, width: 2, decoration: "flat"){
            state "default", label:"", action:"", icon:""}     
        standardTile("emptyButtonSmall", "device.switch", inactiveLabel: false, height: 1, width: 1, decoration: "flat"){
            state "default", label:"", action:"", icon:""} 
    
        main("mainTile")

        details(["mainTile",
            "powerButton",
            "refreshButton",
            "homeButton",
            "muteButton",
            "settingsButton",
            "exitButton",
            "volumeUpButton",
            "inputButton",
            "channelUpButton",
            "volumeDownButton",
            "netflixButton",
            "vuduButton",
            "channelDownButton",
            "youTubeButton",
            "emptyButtonSmall",
            "playButton",
            "pauseButton",
            "upButton",
            "stopButton",
            "returnButton",
            "rewindButton",
            "fastforwardButton",
            "emptyButtonSmall",
            "emptyButtonSmall",
            "leftButton",
            "centerButton",
            "rightButton",
            "blueButton",
            "greenButton",
            "downButton",
            "showKeyButton",
            "redButton",
            "yellowButton"])
    }

    preferences{
        input("tvIP", "string", title:"TV IP Address", description: "", required: true, displayDuringSetup: false)
        input("tvPort", "string", title:"TV Port", description: "", required: true, displayDuringSetup: false)
        input("tvPairingKey", "string", title:"TV Pairing Key", description: "", required: true, displayDuringSetup: false)    
    }
}

// Method is called automatically when installed
def installed(){
    resetState()
}

// Method is called automatically when preferences are updated
def updated(){
    resetState()
}

// Method is called automatically approximately every 5 minutes (by Pollster)
def poll(){
    state.tvPollCount = (state.tvPollCount + 1)
    pollTV()

    // If the TV has been polled more than once without a response, assume it is off
    if (state.tvPollCount > 1 ){
        poweredOff()
    }
}

// Method is called automatically as a result of calling HubAction(), unless a callback is assigned
def parse(description){
    Map response = parseLanMessage(description)

    if (response){
        parseResponse(response)
    }
}

def refresh(){
    setConfiguration()
    poll()
}

def pollTV(){
    getPowerStatus([callback: pollGetPowerStatusCallBack])
}

def pollTVNoPowerStatus(){
    getVolumeInformation([:])
    getContextInformation([:])
}

def on(){
}

def off(){
    sendKeyInputCommand(1, [:])
    poweredOff()
}

private poweredOff(){
    clearVolume()
    state.tvStatus = "off"
    state.playingContent = "TV Off"
    sendEvent(name: "input", value: state.playingContent)
    sendEvent(name: "switch", value: state.tvStatus)
}

private clearVolume(){
    state.tvVolumeLevel = 0
    state.tvMuteStatus = "false"
    sendEvent(name: "level", value: state.tvVolumeLevel)
    sendEvent(name: "mute", value: state.tvMuteStatus)
}

def setLevel(level){
    // Maximum volume level to prevent damage
    if (level > 40){
        level = 40
    }

    if (device.currentValue("switch") == "on"){
        if (state.tvVolumeDesiredLevel == 0){
            state.tvVolumeDesiredLevel = level.intValue()
            state.tvVolumeAdjustPollCount = 0
            getVolumeInformation([callback: checkLevelCallBack])
        }
    } else{
        clearVolume()
    }
}

def setLevelCallBack(physicalgraph.device.HubResponse hubResponse){
    Map response = transformHubResponse(hubResponse)
    parseResponse(response)

    state.tvVolumeAdjustPollCount = (state.tvVolumeAdjustPollCount + 1)
    if (state.tvVolumeAdjustPollCount < 30){
        if (response.status == httpOKStatus()){
            getVolumeInformation([callback: checkLevelCallBack])
        } else{
            state.tvVolumeDesiredLevel = 0
            clearVolume()
        }
    } else{
        state.tvVolumeDesiredLevel = 0
        runIn(5, pollTVNoPowerStatus)
    }
}

def checkLevelCallBack(physicalgraph.device.HubResponse hubResponse){
    Map response = transformHubResponse(hubResponse)
    parseResponse(response)

    if (response.status == httpOKStatus()){
        adjustVolume()
    } else{
        state.tvVolumeDesiredLevel = 0
        clearVolume()
    }
}

private adjustVolume(){
    if (state.tvVolumeLevel <= 40){
        if(state.tvVolumeDesiredLevel > state.tvVolumeLevel){
            state.tvVolumeLevel = (state.tvVolumeLevel + 1)
            sendKeyInputCommand(24, [callback: setLevelCallBack])
        } else if(state.tvVolumeDesiredLevel < state.tvVolumeLevel){
            state.tvVolumeLevel = (state.tvVolumeLevel - 1)
            sendKeyInputCommand(25, [callback: setLevelCallBack])
        } else if(state.tvVolumeDesiredLevel == state.tvVolumeLevel){
            state.tvVolumeDesiredLevel = 0
            state.tvMuteStatus = "false"
            sendEvent(name: "level", value: state.tvVolumeLevel)
            sendEvent(name: "mute", value: state.tvMuteStatus)
        }
    } else{
        state.tvVolumeDesiredLevel = 0
        state.tvMuteStatus = "false"
        sendEvent(name: "level", value: state.tvVolumeLevel)
        sendEvent(name: "mute", value: state.tvMuteStatus)
    }
}

private setConfiguration(){
    state.tvIP = "${tvIP}"
    state.tvPort = "${tvPort}"
    state.tvPairingKey = "${tvPairingKey}"
    state.tvIPHex = state.tvIP.tokenize('.').collect{String.format('%02x', it.toInteger())}.join()
    state.tvPortHex = state.tvPort.tokenize('.').collect {String.format('%04x', it.toInteger())}.join()
    state.tvDeviceNetworkID = ("${state.tvIPHex}:${state.tvPortHex}")

    if (device.currentValue("switch") == "on"){
        getApplicationList([:])
    }
}

private validateConfiguration(){
    if (state.tvIP && state.tvPort && state.tvPairingKey){
        return true
    } else{
        return false
    }
}

private validateTVStatus(){
    if (device.currentValue("switch") == "off"){
        pollTV()
    }
}

private parseResponse(Map response){
    String listName = ""
    def xml

    if(response.status == httpOKStatus()){
        if(response.body){
            xml = parseXml(response.body)
            listName = getDataListName(response.body)

            if(listName == getGetVolumeInformationCommandID()){
                parseGetVolumeInformationResponseXML(xml)
            }
            if(listName == getGetApplicationListCommandID()){
                parseGetApplicationListResponseXML(xml)     
            }
            if(listName == getGetContextInformationCommandID()){
                parseGetContextInformationResponseXML(xml)
            }
        }
    } else if(response.status == httpUnauthorized()){
        sendPairingCommand([:])
    }
}

private getDataListName(String body){
    String dataListNameTag = ""+(body =~ /<dataList name=[^>]*/)[0]
    String dataListName = ""+(dataListNameTag =~ /"(.*?)"/)[0][1]
    return dataListName
}

def pollGetPowerStatusCallBack(physicalgraph.device.HubResponse hubResponse){
    Map response = transformHubResponse(hubResponse)
    state.tvPollCount = 0

    //TV is turned on because we received a successful message back when attempting to pair
    if(response.status == httpOKStatus()){
        state.tvStatus = "on"
        sendEvent(name: "switch", value: state.tvStatus)

        getVolumeInformation([:])
        getContextInformation([:])
    }
}

def sendCommandCallBack(physicalgraph.device.HubResponse hubResponse){
    Map response = transformHubResponse(hubResponse)
    parseResponse(response)
    pollTVNoPowerStatus()
}

private transformHubResponse(physicalgraph.device.HubResponse hubResponse){
    Map response = [:]
    response.put("status", hubResponse.status)
    response.put("body", hubResponse.body)
    return response
}

private getVolumeInformation(Map callBack){
    String messagePath = "/udap/api/data?target=volume_info"
    sendSystemInformationCommand(messagePath, callBack)
}

private getApplicationList(Map callBack){
    String messagePath = "/udap/api/data?target=applist_get&type=1&index=1&number=1024"
    sendSystemInformationCommand(messagePath, callBack)
}

private getContextInformation(Map callBack){
    String messagePath = "/udap/api/data?target=context_ui"
    sendSystemInformationCommand(messagePath, callBack)
}

private parseGetVolumeInformationResponseXML(volumeInformationXML){
    if(volumeInformationXML.dataList.data.level != null && volumeInformationXML.dataList.data.mute != null){
        state.tvMuteStatus = volumeInformationXML.dataList.data.mute.toString()
        if (state.tvMuteStatus == "true"){
            state.tvVolumeLevel = 0
        } else {
            state.tvVolumeLevel = volumeInformationXML.dataList.data.level.toInteger()
        }
        sendEvent(name: "level", value: state.tvVolumeLevel)
        sendEvent(name: "mute", value: state.tvMuteStatus)
    }
}

private parseGetApplicationListResponseXML(applicationListXML){
    Map applicationList = [:]
    ArrayList application = []

    int applicationListLength = applicationListXML.dataList.data.size().toInteger()

    for (int i = 0; i < applicationListLength; i++){
        if (applicationListXML.dataList.data[i].name == "Netflix" || applicationListXML.dataList.data[i].name == "VUDU" || applicationListXML.dataList.data[i].name == "YouTube"){
            application = []
            application.add(applicationListXML.dataList.data[i].auid.toString())
            application.add(applicationListXML.dataList.data[i].cpid.toString())
            applicationList.put(applicationListXML.dataList.data[i].name.toString(), application)
        }
    }
    state.applicationList = applicationList
}

private parseGetContextInformationResponseXML(contextInformationXML){
    if (contextInformationXML.dataList.data.mode != null){
        if (contextInformationXML.dataList.data.mode == "VolCh"){
            state.playingContent = "TV"
        } else if (contextInformationXML.dataList.data.mode == "TouchPad"){
            state.playingContent = "App"
        }
        sendEvent(name: "input", value: state.playingContent)
    }
}

private sendSystemInformationCommand(String messagePath, Map callBack){  
    if(validateConfiguration() == true){
        validateTVStatus()
        def hubActionResult = new physicalgraph.device.HubAction(
            method:     "GET",
            path:       messagePath,
            headers:    [
                            "HOST":             "${state.tvIP}:${state.tvPort}",
                            "Cache-Control":    "no-cache",
                            "Content-Type":     "text/xml; charset=utf-8",
                            "Connection":       "Close",
                            "User-Agent":       "UDAP/2.0"
                        ], null, callBack
        )
        sendHubCommand(hubActionResult)
    } else{
        log.debug("Invalid configuration")
    }
}

private setActiveApp(String applicationName, Map callBack){
    ArrayList application = state.applicationList[applicationName]

    if (application){
        sendAppExecuteCommand(applicationName, application[0], application[1], callBack)
    }
}

private sendAppExecuteCommand(String applicationName, String applicationUID, String applicationContentID, Map callBack){
    String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><envelope><api type=\"command\"><name>AppExecute</name><auid>${applicationUID}</auid><appname>${applicationName}</appname><contentId>${applicationContentID}</contentId></api></envelope>"

    if(validateConfiguration() == true){
        validateTVStatus()
        def hubActionResult = new physicalgraph.device.HubAction(
            method:     "POST",
            path:       "/udap/api/command",
            body:       "${body}",
            headers:    [
                            "HOST":             "${state.tvIP}:${state.tvPort}",
                            "Cache-Control":    "no-cache",
                            "Content-Type":     "text/xml; charset=utf-8",
                            "Content-Length":   body.length(),
                            "Connection":       "Close",
                            "User-Agent":       "UDAP/2.0"
                        ], null, callBack
        )
        sendHubCommand(hubActionResult)
    } else{
        log.debug("Invalid configuration")
    }
}

private getPowerStatus(Map callBack){
    sendPairingCommand(callBack)
}

private sendShowKeyCommand(Map callBack){
    String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><envelope><api type=\"pairing\"><name>showKey</name></api></envelope>"
    sendPairingSystemCommand(body, callBack)
}

private sendPairingCommand(Map callBack){
    String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><envelope><api type=\"pairing\"><name>hello</name><value>${state.tvPairingKey}</value><port>${state.tvPort}</port></api></envelope>"
    sendPairingSystemCommand(body, callBack)
}

private sendPairingSystemCommand(String body, Map callBack){
    if(validateConfiguration() == true){
        def hubActionResult = new physicalgraph.device.HubAction(
            method:     "POST",
            path:       "/udap/api/pairing",
            body:       "${body}",
            headers:    [
                            "HOST":             "${state.tvIP}:${state.tvPort}",
                            "Cache-Control":    "no-cache",
                            "Content-Type":     "text/xml; charset=utf-8",
                            "Content-Length":   body.length(),
                            "Connection":       "Close",
                            "User-Agent":       "UDAP/2.0"
                        ], null, callBack
        )
        sendHubCommand(hubActionResult)
    } else{
        log.debug("Invalid configuration")
    }
}

private sendKeyInput(Integer tvCommand, Map callBack){
    sendKeyInputCommand(tvCommand, callBack)
}

private sendKeyInputCommand(Integer tvCommand, Map callBack){
    String body = "<?xml version=\"1.0\" encoding=\"utf-8\"?><envelope><api type=\"command\"><name>HandleKeyInput</name><value>${tvCommand}</value></api></envelope>"

    if(validateConfiguration() == true){ 
        validateTVStatus()
        def hubActionResult = new physicalgraph.device.HubAction(
            method:     "POST",
            path:       "/udap/api/command",
            body:       "${body}",
            headers:    [
                            "HOST":             "${state.tvIP}:${state.tvPort}",
                            "Cache-Control":    "no-cache",
                            "Content-Type":     "text/xml; charset=utf-8",
                            "Content-Length":   body.length(),
                            "Connection":       "Close",
                            "User-Agent":       "UDAP/2.0"
                        ], null, callBack
        )
        sendHubCommand(hubActionResult)
    } else{
        log.debug("Invalid configuration")
    }
}

private resetState(){ 
    state.tvPollCount = 0
    state.tvVolumeLevel = 0
    state.tvMuteStatus = "false"
    state.tvVolumeDesiredLevel = 0
    state.tvVolumeAdjustPollCount = 0
    state.tvStatus = "off"
    state.tvIP = ""
    state.tvPort = ""
    state.tvPairingKey = ""
    state.tvMacAddress = ""
    state.playingContent = ""
    state.applicationList = [:]
    state.tvIPHex = ""
    state.tvPortHex = ""
    state.tvDeviceNetworkID = ""
}

/* Message constants */
private getGetVolumeInformationCommandID(){
    return "Volume Info"
}

private getGetApplicationListCommandID(){
    return "Max App List"
}

private getGetContextInformationCommandID(){
    return "TV UI Mode"
}

private httpOKStatus(){
    return 200
}

private httpUnauthorized(){
    return 401
}

/* Buttons */
def powerButton(){
    off()
}

def volumeUpButton(){
    sendKeyInput(24, [callback: sendCommandCallBack])
}

def volumeDownButton(){
    sendKeyInput(25, [callback: sendCommandCallBack])
}

def muteButton(){
    sendKeyInput(26, [callback: sendCommandCallBack])
}

def channelUpButton(){
    sendKeyInput(27, [:])
}

def channelDownButton(){
    sendKeyInput(28, [:])
}

def homeButton(){
    sendKeyInput(21, [:])
    runIn(5, pollTVNoPowerStatus)
}

def settingsButton(){
    sendKeyInput(22, [:])
    runIn(5, pollTVNoPowerStatus)
}

def showKeyButton(){
    sendShowKeyCommand([:])
}

def inputButton(){
    sendKeyInput(47, [:])
    runIn(5, pollTVNoPowerStatus)
}

def returnButton(){
    sendKeyInput(23, [:])
    runIn(5, pollTVNoPowerStatus)
}

def exitButton(){
    sendKeyInput(412, [:])
    runIn(5, pollTVNoPowerStatus)
}

def upButton(){
    sendKeyInput(12, [:])
}

def rightButton(){
    sendKeyInput(15, [:])
}

def downButton(){
    sendKeyInput(13, [:])
}

def leftButton(){
    sendKeyInput(14, [:])
}

def centerButton(){
    sendKeyInput(20, [:])
    runIn(5, pollTVNoPowerStatus)
}

def playButton(){
    sendKeyInput(33, [:])
}

def pauseButton(){
    sendKeyInput(34, [:])
}

def rewindButton(){
    sendKeyInput(37, [:])
}

def fastforwardButton(){
    sendKeyInput(36, [:])
}

def stopButton(){
    sendKeyInput(35, [:])
}

def netflixButton(){
    setActiveApp("Netflix", [:])
    runIn(5, pollTVNoPowerStatus)
}

def vuduButton(){
    setActiveApp("VUDU", [:])
    runIn(5, pollTVNoPowerStatus)
}

def youTubeButton(){
    setActiveApp("YouTube", [:])
    runIn(5, pollTVNoPowerStatus)
}

def blueButton(){
    sendKeyInput(29, [:])
}

def greenButton(){
    sendKeyInput(30, [:])
}

def redButton(){
    sendKeyInput(31, [:])
}

def yellowButton(){
    sendKeyInput(32, [:])
}