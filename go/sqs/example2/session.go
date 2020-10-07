package main

import (
	"github.com/aws/aws-sdk-go/aws/session"
)

func InitSession() *session.Session {
	return session.Must(session.NewSessionWithOptions(session.Options{
		SharedConfigState: session.SharedConfigEnable,
	}))
}