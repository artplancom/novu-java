package co.novu.api.organizations;

import co.novu.api.organizations.requests.CreateOrganizationRequest;
import co.novu.api.organizations.requests.UpdateMemberRoleRequest;
import co.novu.api.organizations.requests.UpdateOrganizationBrandRequest;
import co.novu.api.organizations.requests.UpdateOrganizationNameRequest;
import co.novu.api.organizations.responses.FetchMembersResponse;
import co.novu.api.organizations.responses.UpdateOrganizationBrandResponse;
import co.novu.api.organizations.responses.MemberResponse;
import co.novu.api.organizations.responses.OrganizationResponse;
import co.novu.api.organizations.responses.FetchOrganizationResponse;
import co.novu.api.organizations.responses.UpdateOrganizationNameResponse;
import co.novu.common.rest.NovuNetworkException;
import co.novu.common.rest.RestHandler;
import lombok.RequiredArgsConstructor;
import retrofit2.Response;

import java.io.IOException;

@RequiredArgsConstructor
public final class OrganizationHandler {

    private final RestHandler restHandler;

    private final OrganizationApi organizationApi;

    public OrganizationHandler(final RestHandler handler) {
        this.restHandler = handler;
        this.organizationApi = handler.buildRetrofit().create(OrganizationApi.class);
    }


    public OrganizationResponse createOrganization(final CreateOrganizationRequest request)
            throws IOException, NovuNetworkException {
        Response<OrganizationResponse> response = organizationApi.createOrganization(request).execute();
        return restHandler.extractResponse(response);
    }

    public FetchOrganizationResponse fetchAllOrganizations() throws IOException, NovuNetworkException {
        Response<FetchOrganizationResponse> response = organizationApi.fetchAllOrganizations().execute();
        return restHandler.extractResponse(response);
    }

    public UpdateOrganizationNameResponse updateOrganizationName(final UpdateOrganizationNameRequest request)
            throws IOException, NovuNetworkException {
        Response<UpdateOrganizationNameResponse> response = organizationApi.updateOrganizationName(request).execute();
        return restHandler.extractResponse(response);
    }

    public OrganizationResponse fetchCurrentOrganization() throws IOException, NovuNetworkException {
        Response<OrganizationResponse> response = organizationApi.fetchCurrentOrganization().execute();
        return restHandler.extractResponse(response);
    }

    public MemberResponse removeMemberWithId(final String memberId) throws IOException, NovuNetworkException {
        Response<MemberResponse> response = organizationApi.removeMemberWithId(memberId).execute();
        return restHandler.extractResponse(response);
    }

    public MemberResponse updateMemberRole(final String memberId, final UpdateMemberRoleRequest request)
            throws IOException, NovuNetworkException {
        Response<MemberResponse> response = organizationApi.updateMemberRole(memberId, request).execute();
        return restHandler.extractResponse(response);
    }

    public FetchMembersResponse fetchMembersOfOrganization() throws IOException, NovuNetworkException {
        Response<FetchMembersResponse> response = organizationApi.fetchMembersOfOrganization().execute();
        return restHandler.extractResponse(response);
    }

    public UpdateOrganizationBrandResponse updateOrganizationBrand(final UpdateOrganizationBrandRequest request)
            throws IOException, NovuNetworkException {
        Response<UpdateOrganizationBrandResponse> response = organizationApi.updateOrganizationBrand(request).execute();
        return restHandler.extractResponse(response);
    }
}
