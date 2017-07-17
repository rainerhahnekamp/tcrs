
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
