// Generated using typescript-generator version 1.25.322 on 2017-07-15 19:45:33.

declare module "endpoints" {

    interface ReservationAddRequest {
        startDatetime: Date;
        hours: number;
        courtId: string;
        clubId: string;
    }

    interface ClubsListResponse {
        url: string;
        name: string;
    }

    interface ReservationResponse {
        id: string;
        startDatetime: Date;
        hours: number;
    }

}
