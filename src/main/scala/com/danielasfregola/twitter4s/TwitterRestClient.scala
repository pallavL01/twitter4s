package com.danielasfregola.twitter4s

import akka.actor.{ActorRefFactory, ActorSystem}
import com.danielasfregola.twitter4s.entities.{AccessToken, ConsumerToken}
import com.danielasfregola.twitter4s.http.clients.rest.account.TwitterAccountClient
import com.danielasfregola.twitter4s.http.clients.rest.application.TwitterApplicationClient
import com.danielasfregola.twitter4s.http.clients.rest.blocks.TwitterBlockClient
import com.danielasfregola.twitter4s.http.clients.rest.directmessages.TwitterDirectMessageClient
import com.danielasfregola.twitter4s.http.clients.rest.favorites.TwitterFavoriteClient
import com.danielasfregola.twitter4s.http.clients.rest.followers.TwitterFollowerClient
import com.danielasfregola.twitter4s.http.clients.rest.friends.TwitterFriendClient
import com.danielasfregola.twitter4s.http.clients.rest.friendships.TwitterFriendshipClient
import com.danielasfregola.twitter4s.http.clients.rest.geo.TwitterGeoClient
import com.danielasfregola.twitter4s.http.clients.rest.help.TwitterHelpClient
import com.danielasfregola.twitter4s.http.clients.rest.lists.TwitterListClient
import com.danielasfregola.twitter4s.http.clients.rest.media.TwitterMediaClient
import com.danielasfregola.twitter4s.http.clients.rest.mutes.TwitterMuteClient
import com.danielasfregola.twitter4s.http.clients.rest.savedsearches.TwitterSavedSearchClient
import com.danielasfregola.twitter4s.http.clients.rest.search.TwitterSearchClient
import com.danielasfregola.twitter4s.http.clients.rest.statuses.TwitterStatusClient
import com.danielasfregola.twitter4s.http.clients.rest.streaming.TwitterStreamingClient
import com.danielasfregola.twitter4s.http.clients.rest.suggestions.TwitterSuggestionClient
import com.danielasfregola.twitter4s.http.clients.rest.trends.TwitterTrendClient
import com.danielasfregola.twitter4s.http.clients.rest.users.TwitterUserClient
import com.danielasfregola.twitter4s.util.TokensFromConfig

class TwitterRestClient(val consumerToken: ConsumerToken, val accessToken: AccessToken)
                       (implicit val actorRefFactory: ActorRefFactory = ActorSystem("twitter4s")) extends RestClients

trait RestClients extends TwitterAccountClient
  with TwitterApplicationClient
  with TwitterBlockClient
  with TwitterDirectMessageClient
  with TwitterFavoriteClient
  with TwitterFollowerClient
  with TwitterFriendClient
  with TwitterFriendshipClient
  with TwitterGeoClient
  with TwitterHelpClient
  with TwitterListClient
  with TwitterMediaClient
  with TwitterMuteClient
  with TwitterSavedSearchClient
  with TwitterSearchClient
  with TwitterStatusClient
  with TwitterSuggestionClient
  with TwitterUserClient
  with TwitterTrendClient
  with TwitterStreamingClient

object TwitterRestClient {

  def apply(): TwitterRestClient = {
    val consumerToken = ConsumerToken(key = TokensFromConfig.consumerTokenKey, secret = TokensFromConfig.consumerTokenSecret)
    val accessToken = AccessToken(key = TokensFromConfig.accessTokenKey, secret = TokensFromConfig.accessTokenSecret)
    new TwitterRestClient(consumerToken, accessToken)
  }
}
