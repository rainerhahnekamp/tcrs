// Generated using typescript-generator version 1.25.322 on 2017-07-17 10:23:04.

declare module 'endpoints' {

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
