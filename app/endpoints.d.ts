// Generated using typescript-generator version 1.25.322 on 2017-06-10 10:20:48.

declare module "endpoints" {

    interface ReservationAddRequest {
        startDatetime: Date;
        hours: number;
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
