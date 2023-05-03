package no.nav.promStatusProxy.dtos;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * AlertDto
 */
public class AlertDto {

    private String receiver = null;

    private AlertStatusDto status = null;

    private List<Object> alerts = null;

    private Object groupLabels = null;

    private CommonLabelsDto commonLabels = null;

    private CommonAnnotationsDto commonAnnotations = null;

    private String externalURL = null;

    private String version = null;

    private String groupKey = null;

    public AlertDto() {
    }

    public AlertDto(String receiver, AlertStatusDto status, List<Object> alerts, Object groupLabels, CommonLabelsDto commonLabels, CommonAnnotationsDto commonAnnotations, String externalURL, String version, String groupKey) {
        this.receiver = receiver;
        this.status = status;
        this.alerts = alerts;
        this.groupLabels = groupLabels;
        this.commonLabels = commonLabels;
        this.commonAnnotations = commonAnnotations;
        this.externalURL = externalURL;
        this.version = version;
        this.groupKey = groupKey;
    }

    public String getReceiver() {
        return receiver;
    }

    public AlertDto setReceiver(String receiver) {
        this.receiver = receiver;
        return this;
    }

    public AlertStatusDto getStatus() {
        return status;
    }

    public AlertDto setStatus(AlertStatusDto status) {
        this.status = status;
        return this;
    }

    public List<Object> getAlerts() {
        return alerts;
    }

    public AlertDto setAlerts(List<Object> alerts) {
        this.alerts = alerts;
        return this;
    }

    public Object getGroupLabels() {
        return groupLabels;
    }

    public AlertDto setGroupLabels(Object groupLabels) {
        this.groupLabels = groupLabels;
        return this;
    }

    public CommonLabelsDto getCommonLabels() {
        return commonLabels;
    }

    public AlertDto setCommonLabels(CommonLabelsDto commonLabels) {
        this.commonLabels = commonLabels;
        return this;
    }

    public CommonAnnotationsDto getCommonAnnotations() {
        return commonAnnotations;
    }

    public AlertDto setCommonAnnotations(CommonAnnotationsDto commonAnnotations) {
        this.commonAnnotations = commonAnnotations;
        return this;
    }

    public String getExternalURL() {
        return externalURL;
    }

    public AlertDto setExternalURL(String externalURL) {
        this.externalURL = externalURL;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public AlertDto setVersion(String version) {
        this.version = version;
        return this;
    }

    public String getGroupKey() {
        return groupKey;
    }

    public AlertDto setGroupKey(String groupKey) {
        this.groupKey = groupKey;
        return this;
    }
}

